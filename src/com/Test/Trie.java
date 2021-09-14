package com.Test;

import java.util.HashMap;
import java.util.Map;

public class Trie {
    // 定义节点
    class TrieNode {
        private boolean isKeyWordEnd;

        public boolean isKeyWordEnd() {
            return isKeyWordEnd;
        }

        public void setKeyWordEnd(boolean KeyWordEnd) {
            this.isKeyWordEnd = KeyWordEnd;
        }

        public TrieNode() {
            isKeyWordEnd = false;
        }

        // 定义子节点
        private Map<Character, TrieNode> subNodes = new HashMap<>();

        public void addSubNode(Character c, TrieNode node) {
            subNodes.put(c, node);
        }

        public TrieNode getSubNode(Character c) {
            return subNodes.get(c);
        }

    }

    private TrieNode rootNode; // 前缀树根节点
    /** Initialize your data structure here. */
    public Trie() {
        rootNode = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode tmpNode = rootNode;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            TrieNode subNode = tmpNode.getSubNode(c);
            // 如果没有子节点, 则初始化并添加
            if (subNode == null) {
                subNode = new TrieNode();
                tmpNode.addSubNode(c, subNode);
            }
            // 执行子节点, 进入下一轮
            tmpNode = subNode;
            // 设置结束标志
            if (i == word.length()-1) tmpNode.setKeyWordEnd(true);
        }
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode tmpNode = rootNode;
        int position = 0;
        while(position < word.length()) {
            char c = word.charAt(position);
            if(tmpNode.getSubNode(c) == null) {
                return false;
            }
            tmpNode = tmpNode.getSubNode(c);
            position++;
        }

        return true == tmpNode.isKeyWordEnd;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode tmpNode = rootNode;
        int position = 0;
        while(position < prefix.length()) {
            char c = prefix.charAt(position);
            if(tmpNode.getSubNode(c) == null) {
                return false;
            }
            tmpNode = tmpNode.getSubNode(c);
            position++;
        }

        return true;
    }

}
