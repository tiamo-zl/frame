package com.lll.frame.dao.mapper;

import com.hankcs.algorithm.State;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;

/**
 * Description
 *
 * @Author zl
 * @Create 2019-09-05 10:12
 **/
public class AhoCorasickDoubleArrayTrie2<V> implements Serializable {
	protected int[] check;
	protected int[] base;
	protected int[] fail;
	protected int[][] output;
	protected V[] v;
	protected int[] l;
	protected int size;


	public boolean checkText(CharSequence text) {
		int position = 1;
		int currentState = 0;
		List<AhoCorasickDoubleArrayTrie2.Hit<V>> collectedEmits = new ArrayList<>();

		for(int i = 0; i < text.length(); ++i) {
			currentState = this.getState(currentState, text.charAt(i));
			if (!this.storeEmits2(position, currentState, collectedEmits)) {
				return false;
			}
			++position;
		}
		return true;
	}


	public List<AhoCorasickDoubleArrayTrie2.Hit<V>> parseText(CharSequence text) {
		int position = 1;
		int currentState = 0;
		List<AhoCorasickDoubleArrayTrie2.Hit<V>> collectedEmits = new ArrayList<>();

		for(int i = 0; i < text.length(); ++i) {
			currentState = this.getState(currentState, text.charAt(i));
			this.storeEmits(position, currentState, collectedEmits);
			++position;
		}

		return collectedEmits;
	}

	public void parseText(CharSequence text, AhoCorasickDoubleArrayTrie2.IHit<V> processor) {
		int position = 1;
		int currentState = 0;

		for(int i = 0; i < text.length(); ++i) {
			currentState = this.getState(currentState, text.charAt(i));
			int[] hitArray = this.output[currentState];
			if (hitArray != null) {
				int[] var7 = hitArray;
				int var8 = hitArray.length;

				for(int var9 = 0; var9 < var8; ++var9) {
					int hit = var7[var9];
					processor.hit(position - this.l[hit], position, this.v[hit]);
				}
			}

			++position;
		}

	}

	public void parseText(CharSequence text, AhoCorasickDoubleArrayTrie2.IHitCancellable<V> processor) {
		int currentState = 0;

		for(int i = 0; i < text.length(); ++i) {
			int position = i + 1;
			currentState = this.getState(currentState, text.charAt(i));
			int[] hitArray = this.output[currentState];
			if (hitArray != null) {
				int[] var7 = hitArray;
				int var8 = hitArray.length;

				for(int var9 = 0; var9 < var8; ++var9) {
					int hit = var7[var9];
					boolean proceed = processor.hit(position - this.l[hit], position, this.v[hit]);
					if (!proceed) {
						return;
					}
				}
			}
		}

	}

	public void parseText(char[] text, AhoCorasickDoubleArrayTrie2.IHit<V> processor) {
		int position = 1;
		int currentState = 0;
		char[] var5 = text;
		int var6 = text.length;

		for(int var7 = 0; var7 < var6; ++var7) {
			char c = var5[var7];
			currentState = this.getState(currentState, c);
			int[] hitArray = this.output[currentState];
			if (hitArray != null) {
				int[] var10 = hitArray;
				int var11 = hitArray.length;

				for(int var12 = 0; var12 < var11; ++var12) {
					int hit = var10[var12];
					processor.hit(position - this.l[hit], position, this.v[hit]);
				}
			}

			++position;
		}

	}

	public void parseText(char[] text, AhoCorasickDoubleArrayTrie2.IHitFull<V> processor) {
		int position = 1;
		int currentState = 0;
		char[] var5 = text;
		int var6 = text.length;

		for(int var7 = 0; var7 < var6; ++var7) {
			char c = var5[var7];
			currentState = this.getState(currentState, c);
			int[] hitArray = this.output[currentState];
			if (hitArray != null) {
				int[] var10 = hitArray;
				int var11 = hitArray.length;

				for(int var12 = 0; var12 < var11; ++var12) {
					int hit = var10[var12];
					processor.hit(position - this.l[hit], position, this.v[hit], hit);
				}
			}

			++position;
		}

	}

	public boolean matches(String text) {
		int currentState = 0;

		for(int i = 0; i < text.length(); ++i) {
			currentState = this.getState(currentState, text.charAt(i));
			int[] hitArray = this.output[currentState];
			if (hitArray != null) {
				return true;
			}
		}

		return false;
	}

	public AhoCorasickDoubleArrayTrie2.Hit<V> findFirst(String text) {
		int position = 1;
		int currentState = 0;

		for(int i = 0; i < text.length(); ++i) {
			currentState = this.getState(currentState, text.charAt(i));
			int[] hitArray = this.output[currentState];
			if (hitArray != null) {
				int hitIndex = hitArray[0];
				return new AhoCorasickDoubleArrayTrie2.Hit<>(position - this.l[hitIndex], position, this.v[hitIndex]);
			}

			++position;
		}

		return null;
	}

	public void save(ObjectOutputStream out) throws IOException {
		out.writeObject(this.base);
		out.writeObject(this.check);
		out.writeObject(this.fail);
		out.writeObject(this.output);
		out.writeObject(this.l);
		out.writeObject(this.v);
	}

	public void load(ObjectInputStream in) throws IOException, ClassNotFoundException {
		this.base = (int[])((int[])in.readObject());
		this.check = (int[])((int[])in.readObject());
		this.fail = (int[])((int[])in.readObject());
		this.output = (int[][])((int[][])in.readObject());
		this.l = (int[])((int[])in.readObject());
		this.v = (V[]) in.readObject();
	}

	public V get(String key) {
		int index = this.exactMatchSearch(key);
		return index >= 0 ? this.v[index] : null;
	}

	public V get(int index) {
		return this.v[index];
	}

	private int getState(int currentState, char character) {
		int newCurrentState;
		for(newCurrentState = this.transitionWithRoot(currentState, character); newCurrentState == -1; newCurrentState = this.transitionWithRoot(currentState, character)) {
			currentState = this.fail[currentState];
		}

		return newCurrentState;
	}

	private void storeEmits(int position, int currentState, List<AhoCorasickDoubleArrayTrie2.Hit<V>> collectedEmits) {
		int[] hitArray = this.output[currentState];
		if (hitArray != null) {
			int[] var5 = hitArray;
			int var6 = hitArray.length;

			for(int var7 = 0; var7 < var6; ++var7) {
				int hit = var5[var7];
				collectedEmits.add(new AhoCorasickDoubleArrayTrie2.Hit<>(position - this.l[hit], position, this.v[hit]));
			}
		}
	}

	private boolean storeEmits2(int position, int currentState, List<AhoCorasickDoubleArrayTrie2.Hit<V>> collectedEmits) {
		int[] hitArray = this.output[currentState];
		if (hitArray != null) {
			int[] var5 = hitArray;
			int var6 = hitArray.length;

			for(int var7 = 0; var7 < var6; ++var7) {
				int hit = var5[var7];
				collectedEmits.add(new AhoCorasickDoubleArrayTrie2.Hit<>(position - this.l[hit], position, this.v[hit]));
				return false;
			}
		}
		return true;
	}

	protected int transition(int current, char c) {
		int p = current + c + 1;
		if (current == this.check[p]) {
			int b = this.base[p];
			return b;
		} else {
			return -1;
		}
	}

	protected int transitionWithRoot(int nodePos, char c) {
		int b = this.base[nodePos];
		int p = b + c + 1;
		if (b != this.check[p]) {
			return nodePos == 0 ? 0 : -1;
		} else {
			return p;
		}
	}

	public void build(Map<String, V> map) {
		(new AhoCorasickDoubleArrayTrie2.Builder()).build(map);
	}

	public int exactMatchSearch(String key) {
		return this.exactMatchSearch((String)key, 0, 0, 0);
	}

	private int exactMatchSearch(String key, int pos, int len, int nodePos) {
		if (len <= 0) {
			len = key.length();
		}

		if (nodePos <= 0) {
			nodePos = 0;
		}

		int result = -1;
		char[] keyChars = key.toCharArray();
		int b = this.base[nodePos];

		int n;
		for(n = pos; n < len; ++n) {
			int p = b + keyChars[n] + 1;
			if (b != this.check[p]) {
				return result;
			}

			b = this.base[p];
		}

		n = this.base[b];
		if (b == this.check[b] && n < 0) {
			result = -n - 1;
		}

		return result;
	}

	private int exactMatchSearch(char[] keyChars, int pos, int len, int nodePos) {
		int result = -1;
		int b = this.base[nodePos];

		int n;
		for(n = pos; n < len; ++n) {
			int p = b + keyChars[n] + 1;
			if (b != this.check[p]) {
				return result;
			}

			b = this.base[p];
		}

		n = this.base[b];
		if (b == this.check[b] && n < 0) {
			result = -n - 1;
		}

		return result;
	}

	public int size() {
		return this.v.length;
	}

	private class Builder {
		private State rootState;
		private boolean[] used;
		private int allocSize;
		private int progress;
		private int nextCheckPos;
		private int keySize;

		private Builder() {
			this.rootState = new State();
		}

		public void build(Map<String, V> map) {
			AhoCorasickDoubleArrayTrie2.this.v = (V[]) map.values().toArray();
			AhoCorasickDoubleArrayTrie2.this.l = new int[AhoCorasickDoubleArrayTrie2.this.v.length];
			Set<String> keySet = map.keySet();
			this.addAllKeyword(keySet);
			this.buildDoubleArrayTrie(keySet.size());
			this.used = null;
			this.constructFailureStates();
			this.rootState = null;
			this.loseWeight();
		}

		private int fetch(State parent, List<Map.Entry<Integer, State>> siblings) {
			if (parent.isAcceptable()) {
				State fakeNode = new State(-(parent.getDepth() + 1));
				fakeNode.addEmit(parent.getLargestValueId());
				siblings.add(new AbstractMap.SimpleEntry(0, fakeNode));
			}

			Iterator<Map.Entry<Character, State>> var5 = parent.getSuccess().entrySet().iterator();

			while(var5.hasNext()) {
				Map.Entry<Character, State> entry = var5.next();
				siblings.add(new AbstractMap.SimpleEntry((Character)entry.getKey() + 1, entry.getValue()));
			}

			return siblings.size();
		}

		private void addKeyword(String keyword, int index) {
			State currentState = this.rootState;
			char[] var4 = keyword.toCharArray();
			int var5 = var4.length;

			for(int var6 = 0; var6 < var5; ++var6) {
				Character character = var4[var6];
				currentState = currentState.addState(character);
			}

			currentState.addEmit(index);
			AhoCorasickDoubleArrayTrie2.this.l[index] = keyword.length();
		}

		private void addAllKeyword(Collection<String> keywordSet) {
			int i = 0;
			Iterator<String> var3 = keywordSet.iterator();

			while(var3.hasNext()) {
				String keyword = var3.next();
				this.addKeyword(keyword, i++);
			}

		}

		private void constructFailureStates() {
			AhoCorasickDoubleArrayTrie2.this.fail = new int[AhoCorasickDoubleArrayTrie2.this.size + 1];
			AhoCorasickDoubleArrayTrie2.this.fail[1] = AhoCorasickDoubleArrayTrie2.this.base[0];
			AhoCorasickDoubleArrayTrie2.this.output = new int[AhoCorasickDoubleArrayTrie2.this.size + 1][];
			Queue<State> queue = new ArrayDeque<>();
			Iterator<State> var2 = this.rootState.getStates().iterator();

			while(var2.hasNext()) {
				State depthOneState = var2.next();
				depthOneState.setFailure(this.rootState, AhoCorasickDoubleArrayTrie2.this.fail);
				queue.add(depthOneState);
				this.constructOutput(depthOneState);
			}

			while(!queue.isEmpty()) {
				State currentState = (State)queue.remove();
				Iterator<Character> var9 = currentState.getTransitions().iterator();

				while(var9.hasNext()) {
					Character transition = var9.next();
					State targetState = currentState.nextState(transition);
					queue.add(targetState);

					State traceFailureState;
					for(traceFailureState = currentState.failure(); traceFailureState.nextState(transition) == null; traceFailureState = traceFailureState.failure()) {
					}

					State newFailureState = traceFailureState.nextState(transition);
					targetState.setFailure(newFailureState, AhoCorasickDoubleArrayTrie2.this.fail);
					targetState.addEmit(newFailureState.emit());
					this.constructOutput(targetState);
				}
			}

		}

		private void constructOutput(State targetState) {
			Collection<Integer> emit = targetState.emit();
			if (emit != null && emit.size() != 0) {
				int[] output = new int[emit.size()];
				Iterator<Integer> it = emit.iterator();

				for(int i = 0; i < output.length; ++i) {
					output[i] = (Integer)it.next();
				}

				AhoCorasickDoubleArrayTrie2.this.output[targetState.getIndex()] = output;
			}
		}

		private void buildDoubleArrayTrie(int keySize) {
			this.progress = 0;
			this.keySize = keySize;
			this.resize(2097152);
			AhoCorasickDoubleArrayTrie2.this.base[0] = 1;
			this.nextCheckPos = 0;
			State root_node = this.rootState;
			List<Map.Entry<Integer, State>> siblings = new ArrayList<>(root_node.getSuccess().entrySet().size());
			this.fetch(root_node, siblings);
			this.insert(siblings);
		}

		private int resize(int newSize) {
			int[] base2 = new int[newSize];
			int[] check2 = new int[newSize];
			boolean[] used2 = new boolean[newSize];
			if (this.allocSize > 0) {
				System.arraycopy(AhoCorasickDoubleArrayTrie2.this.base, 0, base2, 0, this.allocSize);
				System.arraycopy(AhoCorasickDoubleArrayTrie2.this.check, 0, check2, 0, this.allocSize);
				System.arraycopy(this.used, 0, used2, 0, this.allocSize);
			}

			AhoCorasickDoubleArrayTrie2.this.base = base2;
			AhoCorasickDoubleArrayTrie2.this.check = check2;
			this.used = used2;
			return this.allocSize = newSize;
		}

		private int insert(List<Map.Entry<Integer, State>> siblings) {
			int pos = Math.max((Integer)((Map.Entry)siblings.get(0)).getKey() + 1, this.nextCheckPos) - 1;
			int nonzero_num = 0;
			boolean first = false;
			if (this.allocSize <= pos) {
				this.resize(pos + 1);
			}

			while(true) {
				label76:
				while(true) {
					++pos;
					if (this.allocSize <= pos) {
						this.resize(pos + 1);
					}

					if (AhoCorasickDoubleArrayTrie2.this.check[pos] != 0) {
						++nonzero_num;
					} else {
						if (!first) {
							this.nextCheckPos = pos;
							first = true;
						}

						int beginx = pos - (Integer)((Map.Entry)siblings.get(0)).getKey();
						if (this.allocSize <= beginx + (Integer)((Map.Entry)siblings.get(siblings.size() - 1)).getKey()) {
							double l = 1.05D > 1.0D * (double)this.keySize / (double)(this.progress + 1) ? 1.05D : 1.0D * (double)this.keySize / (double)(this.progress + 1);
							this.resize((int)((double)this.allocSize * l));
						}

						if (!this.used[beginx]) {
							for(int i = 1; i < siblings.size(); ++i) {
								if (AhoCorasickDoubleArrayTrie2.this.check[beginx + (Integer)((Map.Entry)siblings.get(i)).getKey()] != 0) {
									continue label76;
								}
							}

							if (1.0D * (double)nonzero_num / (double)(pos - this.nextCheckPos + 1) >= 0.95D) {
								this.nextCheckPos = pos;
							}

							this.used[beginx] = true;
							AhoCorasickDoubleArrayTrie2.this.size = AhoCorasickDoubleArrayTrie2.this.size > beginx + (Integer)((Map.Entry)siblings.get(siblings.size() - 1)).getKey() + 1 ? AhoCorasickDoubleArrayTrie2.this.size : beginx + (Integer)((Map.Entry)siblings.get(siblings.size() - 1)).getKey() + 1;

							Map.Entry<Integer, State> sibling;
							Iterator<Map.Entry<Integer, State>> var12;
							for(var12 = siblings.iterator(); var12.hasNext(); AhoCorasickDoubleArrayTrie2.this.check[beginx + sibling.getKey()] = beginx) {
								sibling = var12.next();
							}

							for(var12 = siblings.iterator(); var12.hasNext(); (sibling.getValue()).setIndex(beginx + sibling.getKey())) {
								sibling = var12.next();
								List<Map.Entry<Integer, State>> new_siblings = new ArrayList<>((sibling.getValue()).getSuccess().entrySet().size() + 1);
								if (this.fetch(sibling.getValue(), new_siblings) == 0) {
									AhoCorasickDoubleArrayTrie2.this.base[beginx + sibling.getKey()] = -(sibling.getValue()).getLargestValueId() - 1;
									++this.progress;
								} else {
									int h = this.insert(new_siblings);
									AhoCorasickDoubleArrayTrie2.this.base[beginx + sibling.getKey()] = h;
								}
							}

							return beginx;
						}
					}
				}
			}
		}

		private void loseWeight() {
			int[] nbase = new int[AhoCorasickDoubleArrayTrie2.this.size + '\uffff'];
			System.arraycopy(AhoCorasickDoubleArrayTrie2.this.base, 0, nbase, 0, AhoCorasickDoubleArrayTrie2.this.size);
			AhoCorasickDoubleArrayTrie2.this.base = nbase;
			int[] ncheck = new int[AhoCorasickDoubleArrayTrie2.this.size + '\uffff'];
			System.arraycopy(AhoCorasickDoubleArrayTrie2.this.check, 0, ncheck, 0, AhoCorasickDoubleArrayTrie2.this.size);
			AhoCorasickDoubleArrayTrie2.this.check = ncheck;
		}
	}

	public static class Hit<V> {
		public final int begin;
		public final int end;
		public final V value;

		public Hit(int begin, int end, V value) {
			this.begin = begin;
			this.end = end;
			this.value = value;
		}

		public String toString() {
			return String.format("[%d:%d]=%s", this.begin, this.end, this.value);
		}
	}

	public interface IHitCancellable<V> {
		boolean hit(int var1, int var2, V var3);
	}

	public interface IHitFull<V> {
		void hit(int var1, int var2, V var3, int var4);
	}

	public interface IHit<V> {
		void hit(int var1, int var2, V var3);
	}
}

