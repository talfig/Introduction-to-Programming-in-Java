public class StringList {
    private StringNode _head;

    public StringList(String s) {
        _head = new StringNode('0', 0, null);
        StringNode tmp1 = _head, tmp2 = null;
        for (int i = 0; i < s.length(); i++) {
            int c = 1;
            int j = i + 1;
            for (; j < s.length() && s.charAt(i) == s.charAt(j); j++, c++);
            tmp2 = new StringNode(s.charAt(i), c, null);
            tmp1.setNext(tmp2);
            tmp1 = tmp1.getNext();
            i = j - 1;
        }
        _head = _head.getNext();
    }
    public String toString() {
        StringNode p = _head;
        String a = "";
        while (p != null) {
            a += p.getData() + "\t";
            a += p.getCount() + "\n";
            p = p.getNext();
        }
        return a;
    }

    public int what(char ch, int fr) {
        StringNode pos = _head;
        int c = 0, c1 = 0;
        while (pos != null && c < fr) {
            c = c + pos.getCount();
            if (c <= fr)
                pos = pos.getNext();
        }
        if (pos == null)
            return -1;
        c1 = help(ch, pos);
        if (c1 == -1)
            return -1;
        if (c1 > 0)
            c1 -= (c - fr);
        return fr + c1;
    }

    private int help(char ch, StringNode pos) {
        boolean found = false;
        int c = 0;
        while (pos != null && !found) {
            if (pos.getData() == ch)
                found = true;
            else {
                c += pos.getCount();
                pos = pos.getNext();
            }
        }
        if (found)
            return c;
        return -1;
    }
}
