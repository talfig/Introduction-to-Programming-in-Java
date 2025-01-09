public class StringNode {
    private char _data;
    private int _count;
    private StringNode _next;
    public StringNode (char ch, int num, StringNode n) {
        _data = ch;
        _count = num;
        _next = n;
    }
    public StringNode getNext() {
        return _next;
    }
    public void setNext(StringNode node) {
        _next = node;
    }
    public int getCount() {
        return _count;
    }
    public void setCount(int v) {
        _count = v;
    }
    public char getData() {
        return _data;
    }
    public void setData(char ch) {
        _data = ch;
    }
}