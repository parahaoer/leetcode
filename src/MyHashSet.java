class MyHashSet {
    int capacity = 8;
    int size = 0;
    int[] s = new int[capacity];
    float lf = (float) 2/3;

    /** Initialize your data structure here. */
    public MyHashSet() {

    }

    public int myhash(int key) {
        return key % capacity;
    }

    public int myrehash(int n) {
        return (5*n+1) % capacity;
    }

    public void add(int key) {

        if((float) size/capacity >= lf) {
            // capacity = 2 * capacity;
            capacity = capacity <<1;
            int[] ns = new int[capacity];
            // for(int i=0; i<capacity/2; i++) {
            for(int i=0; i<(capacity>>1);i++) {
                if(s[i] ==0 || s[i]==-1) continue;
                int n = myhash(s[i]);
                //ns是新数组，所以不存在元素为-1的情况
//                while(ns[n] !=0 || ns[n] != -1) {
//                    n = myrehash(n);
                while(ns[n] !=0) {
                    n = myrehash(n);
                }
                ns[n] = s[i];
            }
            s = ns;
        }

        int h = myhash(key);
        while(s[h] != 0) {
            if(s[h] == -1) break;
            if(s[h] == key) return;
            h = myrehash(h);
        }
        s[h] = key;
        size++;

    }

    public void remove(int key) {
        int h = myhash(key);
        // if(s[h] == key) {
        //     s[h] = 0;
        //     size--;
        // }
        // while(s[h] != 0 && s[h] != key) {
        //     h = myrehash(h);
        //     //if(s[h]==0) return false;
        //     if(s[h] == key) {
        //         s[h] = 0;
        //         size--;
        //     }
        // }
        while(s[h] != 0 || s[h] == -1) {
            if(s[h] == key) {
                //删除元素后将该位置的值致为0，存在问题。
                //如果某个位置m因为已经有元素而被rehash到其他位置n。当位置m的元素被删除后，对位置n的元素使用contains方法会先到位置m，而位置m因为删除了原来的值而被致0，contains方法直接返回false。
//                s[h] = 0;
                s[h] = -1;
                size --;
            }
            h = myrehash(h);
        }
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int h = myhash(key);
        // while(s[h] != 0 && s[h] != key) {
        //     h = myrehash(h);
        // }
        // if(s[h]==0) return false;
        // if(s[h] == key) return true;
        // return false;
        while(s[h] != 0 || s[h] == -1) {
            if(s[h] == key) return true;
            h = myrehash(h);
        }
        return false;
    }

    public void test(MyHashSet myHashSet) {
        myHashSet.remove(1);
        myHashSet.add(9);
        myHashSet.remove(24);
        myHashSet.add(53);
        myHashSet.add(84);
        myHashSet.remove(90);
        myHashSet.add(34);
        myHashSet.contains(9);
        myHashSet.add(39);
        myHashSet.contains(84);
        myHashSet.add(18);
        myHashSet.contains(9);
        myHashSet.remove(2);
        myHashSet.remove(34);
        boolean res = myHashSet.contains(18); //////////
        System.out.println(res);
        myHashSet.add(68);
        myHashSet.add(93);
        myHashSet.add(62);
        myHashSet.add(24);
        myHashSet.contains(76);
        myHashSet.remove(15);
        myHashSet.contains(88);
        myHashSet.contains(46);
        myHashSet.remove(32);
        myHashSet.add(56);
        myHashSet.contains(62);
        myHashSet.add(68);
        myHashSet.add(99);
        myHashSet.contains(9);
        myHashSet.add(69);
        myHashSet.add(74);
        myHashSet.add(55);
        myHashSet.add(91);
        myHashSet.add(21);
        myHashSet.contains(83);
        myHashSet.add(43);
        myHashSet.add(47);
        myHashSet.remove(91);
        myHashSet.add(17);
        myHashSet.contains(16);
        myHashSet.add(3);
        myHashSet.add(2);
        myHashSet.add(29);
        myHashSet.add(15);
        myHashSet.remove(59);
        myHashSet.add(54);
        myHashSet.contains(2);
        myHashSet.add(86);
        myHashSet.add(18);
        myHashSet.add(30);
        myHashSet.add(69);
        myHashSet.remove(66);
        myHashSet.remove(15);
        myHashSet.contains(76);
        myHashSet.contains(55);
        myHashSet.add(1);
        myHashSet.contains(87);
        myHashSet.contains(52);
        myHashSet.add(61);
        myHashSet.contains(84);
        myHashSet.remove(23);
        myHashSet.contains(61);
        myHashSet.contains(19);
        myHashSet.remove(99);
        myHashSet.add(33);
        myHashSet.add(63);
        myHashSet.add(72);
        myHashSet.contains(45);
        myHashSet.add(92);
        myHashSet.contains(72);
        myHashSet.add(7);
        myHashSet.add(29);
        myHashSet.add(74);
        myHashSet.add(0);
        myHashSet.add(97);
        myHashSet.contains(63);
        myHashSet.contains(92);
        myHashSet.remove(85);
        myHashSet.contains(0);
        myHashSet.add(83);
        myHashSet.remove(17);
        myHashSet.add(32);
        myHashSet.add(35);
        myHashSet.add(91);
        myHashSet.contains(80);
        myHashSet.add(95);
        myHashSet.add(75);
        myHashSet.add(18);
        myHashSet.add(18);
        myHashSet.add(38);
        myHashSet.add(43);
        myHashSet.remove(14);
        myHashSet.add(40);
        myHashSet.contains(46);
        myHashSet.add(25);
        myHashSet.add(42);
        myHashSet.add(99);
        myHashSet.contains(47);
        myHashSet.add(57);
        myHashSet.add(25);
    }

    public void test2(MyHashSet myHashSet) {
        myHashSet.remove(1);
        myHashSet.add(9);
        myHashSet.remove(24);
        myHashSet.add(53);
        myHashSet.add(84);
        myHashSet.remove(90);
        myHashSet.add(34);
        myHashSet.contains(9);
        myHashSet.add(39);
        myHashSet.contains(84);
        myHashSet.add(18);
        myHashSet.contains(9);
        myHashSet.remove(2);
        myHashSet.remove(34);
        myHashSet.contains(18);
        myHashSet.add(68);
        myHashSet.add(93);
        myHashSet.add(62);
        myHashSet.add(24);
        myHashSet.contains(76);
        myHashSet.remove(15);
        myHashSet.contains(88);
        myHashSet.contains(46);
        myHashSet.remove(32);
        myHashSet.add(56);
        myHashSet.contains(62);
        myHashSet.add(68);
        myHashSet.add(99);
        myHashSet.contains(9);
        myHashSet.add(69);
        myHashSet.add(74);
        myHashSet.add(55);
        myHashSet.add(91);
        myHashSet.add(21);
        myHashSet.contains(83);
        myHashSet.add(43);
        myHashSet.add(47);
        myHashSet.remove(91);
        myHashSet.add(17);
        myHashSet.contains(16);
        myHashSet.add(3);
        myHashSet.add(2);
        myHashSet.add(29);
        myHashSet.add(15);
        myHashSet.remove(59);
        myHashSet.add(54);
        myHashSet.contains(2);
        myHashSet.add(86);
        myHashSet.add(18);
        myHashSet.add(30);
        myHashSet.add(69);
        myHashSet.remove(66);
        myHashSet.remove(15);
        myHashSet.contains(76);
        myHashSet.contains(55);
        myHashSet.add(1);
        myHashSet.contains(87);
        myHashSet.contains(52);
        myHashSet.add(61);
        myHashSet.contains(84);
        myHashSet.remove(23);
        myHashSet.contains(61);
        myHashSet.contains(19);
        myHashSet.remove(99);
        myHashSet.add(33);
        myHashSet.add(63);
        myHashSet.add(72);
        myHashSet.contains(45);
        myHashSet.add(92);
        myHashSet.contains(72);
        myHashSet.add(7);
        myHashSet.add(29);
        myHashSet.add(74);
        myHashSet.add(0);
        myHashSet.add(97);
        myHashSet.contains(63);
        myHashSet.contains(92);
        myHashSet.remove(85);
        myHashSet.contains(0);
        myHashSet.add(83);
        myHashSet.remove(17);
        myHashSet.add(32);
        myHashSet.add(35);
        myHashSet.add(91);
        myHashSet.contains(80);
        myHashSet.add(95);
        myHashSet.add(75);
        myHashSet.add(18);
        myHashSet.add(18);
        myHashSet.add(38);
        myHashSet.add(43);
        myHashSet.remove(14);
        myHashSet.add(40);
        myHashSet.contains(46);
        myHashSet.add(25);
        myHashSet.add(42);
        myHashSet.add(99);
        myHashSet.contains(47);
        myHashSet.add(57);
        myHashSet.add(25);
    }

    public void test3(MyHashSet myHashSet) {
        myHashSet.contains(72);
        myHashSet.remove(91);
        myHashSet.add(48);
        myHashSet.add(41);
        myHashSet.contains(96);
        myHashSet.remove(87);
        myHashSet.contains(48);
        myHashSet.contains(49);
        myHashSet.add(84);
        myHashSet.add(82);
        myHashSet.add(24);
        myHashSet.add(7);
        myHashSet.remove(56);
        myHashSet.add(87);
        myHashSet.add(81);
        myHashSet.add(55);
        myHashSet.add(19);
        myHashSet.add(40);
        myHashSet.add(68);
        myHashSet.add(23);
        myHashSet.add(80);
        myHashSet.add(53);
        myHashSet.add(76);
        myHashSet.contains(93);
        myHashSet.add(95);
        myHashSet.contains(95);
        myHashSet.add(67);
        myHashSet.add(31);
        myHashSet.contains(80);
        myHashSet.add(62);
        myHashSet.add(73);
        myHashSet.remove(97);
        myHashSet.add(33);
        myHashSet.add(28);
        myHashSet.add(62);
        myHashSet.add(81);
        myHashSet.add(57);
        myHashSet.contains(40);
        myHashSet.add(11);
        myHashSet.add(89);
        myHashSet.add(28);
        myHashSet.remove(97);
        myHashSet.contains(86);
        myHashSet.add(20);
        myHashSet.contains(5);
        myHashSet.add(77);
        myHashSet.add(52);
        myHashSet.add(57);
        myHashSet.add(88);
        myHashSet.add(20);
        myHashSet.contains(48);
        myHashSet.remove(42);
        myHashSet.remove(86);
        myHashSet.add(49);
        myHashSet.remove(62);
        myHashSet.contains(53);
        myHashSet.add(43);
        myHashSet.remove(98);
        myHashSet.add(32);
        myHashSet.add(15);
        myHashSet.add(42);
        myHashSet.add(50);
        myHashSet.contains(19);
        myHashSet.contains(32);
        myHashSet.add(67);
        myHashSet.remove(84);
        myHashSet.remove(60);
        myHashSet.remove(8);
        myHashSet.remove(85);
        myHashSet.add(43);
        myHashSet.add(59);
        myHashSet.contains(65);
        myHashSet.add(40);
        myHashSet.add(81);
        myHashSet.remove(55);
        myHashSet.add(56);
        myHashSet.add(54);
        myHashSet.add(59);
        myHashSet.add(78);
        myHashSet.add(53);
        myHashSet.add(0);
        myHashSet.add(24);
        myHashSet.add(7);
        myHashSet.remove(53);
        myHashSet.add(33);
        myHashSet.remove(69);
        myHashSet.remove(86);
        myHashSet.add(7);
        myHashSet.remove(1);
        myHashSet.add(16);
        myHashSet.remove(58);
        myHashSet.add(61);
        myHashSet.add(34);
        myHashSet.add(53);
        myHashSet.remove(84);
        myHashSet.remove(21);
        myHashSet.remove(58);
        myHashSet.add(25);
        myHashSet.contains(45);
        myHashSet.add(3);
    }

    public void test4(MyHashSet myHashSet) {
        myHashSet.remove(1);
        myHashSet.add(9);
        myHashSet.remove(24);
        myHashSet.add(53);
        myHashSet.add(84);
        myHashSet.remove(90);
        myHashSet.add(34);
        myHashSet.contains(9);
        myHashSet.add(39);
        myHashSet.contains(84);
        myHashSet.add(18);
        myHashSet.contains(9);
        myHashSet.remove(2);
        myHashSet.remove(34);
        myHashSet.contains(18);
        myHashSet.add(68);
        myHashSet.add(93);
        myHashSet.add(62);
        myHashSet.add(24);
        myHashSet.contains(76);
        myHashSet.remove(15);
        myHashSet.contains(88);
        myHashSet.contains(46);
        myHashSet.remove(32);
        myHashSet.add(56);
        myHashSet.contains(62);
        myHashSet.add(68);
        myHashSet.add(99);
        myHashSet.contains(9);
        myHashSet.add(69);
        myHashSet.add(74);
        myHashSet.add(55);
        myHashSet.add(91);
        myHashSet.add(21);
        myHashSet.contains(83);
        myHashSet.add(43);
        myHashSet.add(47);
        myHashSet.remove(91);
        myHashSet.add(17);
        myHashSet.contains(16);
        myHashSet.add(3);
        myHashSet.add(2);
        myHashSet.add(29);
        myHashSet.add(15);
        myHashSet.remove(59);
        myHashSet.add(54);
        myHashSet.contains(2);
        myHashSet.add(86);
        myHashSet.add(18);
        myHashSet.add(30);
        myHashSet.add(69);
        myHashSet.remove(66);
        myHashSet.remove(15);
        myHashSet.contains(76);
        myHashSet.contains(55);
        myHashSet.add(1);
        myHashSet.contains(87);
        myHashSet.contains(52);
        myHashSet.add(61);
        myHashSet.contains(84);
        myHashSet.remove(23);
        myHashSet.contains(61);
        myHashSet.contains(19);
        myHashSet.remove(99);
        myHashSet.add(33);
        myHashSet.add(63);
        myHashSet.add(72);
        myHashSet.contains(45);
        myHashSet.add(92);
        myHashSet.contains(72);
        myHashSet.add(7);
        myHashSet.add(29);
        myHashSet.add(74);
        myHashSet.add(0);
        myHashSet.add(97);
        myHashSet.contains(63);
        myHashSet.contains(92);
        myHashSet.remove(85);
        myHashSet.contains(0);
        myHashSet.add(83);
        myHashSet.remove(17);
        myHashSet.add(32);
        myHashSet.add(35);
        myHashSet.add(91);
        myHashSet.contains(80);
        myHashSet.add(95);
        myHashSet.add(75);
        myHashSet.add(18);
        myHashSet.add(18);
        myHashSet.add(38);
        myHashSet.add(43);
        myHashSet.remove(14);
        myHashSet.add(40);
        myHashSet.contains(46);
        myHashSet.add(25);
        myHashSet.add(42);
        myHashSet.add(99);
        myHashSet.contains(47);
        myHashSet.add(57);
        myHashSet.add(25);
    }

    public static void main(String[] args) {
        MyHashSet myHashSet = new MyHashSet();
        myHashSet.test4(myHashSet);
    }
}