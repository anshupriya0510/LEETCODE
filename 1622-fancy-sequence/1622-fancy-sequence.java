import java.util.*;

class Fancy {

    long mod = 1000000007;
    long mul = 1;
    long add = 0;

    List<Long> list;

    public Fancy() {
        list = new ArrayList<>();
    }

    public void append(int val) {
        long normalized = (val - add) % mod;
        normalized = (normalized * modInverse(mul)) % mod;
        if (normalized < 0) normalized += mod;
        list.add(normalized);
    }

    public void addAll(int inc) {
        add = (add + inc) % mod;
    }

    public void multAll(int m) {
        mul = (mul * m) % mod;
        add = (add * m) % mod;
    }

    public int getIndex(int idx) {
        if (idx >= list.size()) return -1;

        long val = list.get(idx);
        val = (val * mul) % mod;
        val = (val + add) % mod;

        return (int) val;
    }

    private long modInverse(long x) {
        return pow(x, mod - 2);
    }

    private long pow(long a, long b) {
        long res = 1;
        a %= mod;

        while (b > 0) {
            if ((b & 1) == 1)
                res = (res * a) % mod;

            a = (a * a) % mod;
            b >>= 1;
        }

        return res;
    }
}
/**
 * Your Fancy object will be instantiated and called as such:
 * Fancy obj = new Fancy();
 * obj.append(val);
 * obj.addAll(inc);
 * obj.multAll(m);
 * int param_4 = obj.getIndex(idx);
 */