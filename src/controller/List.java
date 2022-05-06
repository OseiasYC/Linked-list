package controller;

import classes.Tie;

public class List {
    Tie head;
    int size;

    public void setHead(String information) {
        Tie tie = new Tie();
        tie.information = information;
        tie.next = head;
        head = tie;
        size++;
    }

    public void setTail(String information) {
        Tie tie = new Tie();
        tie.information = information;
        if (head == null) {
            head = tie;
            tie.next = null;
        } else {
            Tie local = head;
            while (local.next != null) {
                local = local.next;
            }
            local.next = tie;
            tie.next = null;
        }
        size++;
    }

    public boolean findString(String information) {
        Tie local = head;
        boolean result = false;
        for (int i = 0; i < size; i++) {
            if (local.information.equals(information)) {
                result = true;
            }
            local = local.next;
        }
        return result;
    }

    @Override
    public String toString() {
        String str = "(" + size + ") ";
        Tie local = head;
        while (local != null) {
            str += "[" + local.information + "] ";
            local = local.next;
        }
        return str;
    }

    public String removeIndex(int position) {
        if (head == null || position >= size || position < 0) {
            return null;
        } else if (position == 0) {
            removeHead();
        } else if (position == size - 1) {
            removeTail();
        }
        Tie local = head;
        for (int index = 0; index < position - 1; index++) {
            local = local.next;
        }
        String removed = local.next.information;
        local.next = local.next.next;
        size--;
        return removed;
    }

    private String removeHead() {
        if (head == null) {
            return null;
        }
        String information = head.information;
        head = head.next;
        size--;
        return information;
    }

    private String removeTail() {
        if (head == null) {
            return null;
        }
        Tie local = head;
        while (local.next != null) {
            Tie aid = local;
            local = local.next;
            if (local.next == null) {
                aid.next = null;
                size--;
                return local.information;
            }
        }
        head = null;
        size--;
        return local.information;
    }

}
