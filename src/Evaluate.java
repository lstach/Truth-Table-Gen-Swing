public class Evaluate {

    public Evaluate() {

    }

    boolean and(boolean p, boolean q) {
        return (p && q);
    }

    boolean or(boolean p, boolean q) {
        return (p || q);
    }

    boolean xor(boolean p, boolean q) {
        return (p ^ q);
    }

    boolean implies(boolean p, boolean q) {
        return (!p || q); // !p \/ q is logically equivalent to p implies q
    }

    boolean iff(boolean p, boolean q) {
        return (((p && q) || (!p && !q)));
    }

    boolean not(boolean p) {
        return (!p);
    }
}
