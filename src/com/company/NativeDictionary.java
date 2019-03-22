package com.company;

import java.lang.reflect.Array;

class NativeDictionary<T> {
    public int size;
    public String[] slots;
    public T[] values;
    public int step;

    public NativeDictionary(int sz, Class clazz) {
        size = sz;
        slots = new String[size];
        step = 3;
        values = (T[]) Array.newInstance(clazz, this.size);
    }

    public int hashFun(String key) {
        // всегда возвращает корректный индекс слота
        char[] n = key.toCharArray();
        int v = 0;
        for(int i = 0; i<n.length;i++){
            v += (int)n[i];
        }
        int hash = v % size;
        return hash;
    }

    public int seekSlot(String value)
    {
        // находит индекс пустого слота для значения, или -1
        int hash = hashFun(value);
        int h = hash;
        while(slots[hash] != null){
            hash += step;
            if(hash >= slots.length){
                int dif = hash - slots.length;
                hash = dif;
            }
        }
        return hash;
    }

    public boolean isKey(String key) {
        // возвращает true если ключ имеется,
        // иначе false
        int a = hashFun(key);
        boolean flag = false;
        while(slots[a] != null){
            if(slots[a].equals(key)){
                //flag = true;
                return true;
            }
            a += step;
            if(a >= slots.length){
                int dif = a - slots.length;
                a = dif;
            }
            if(slots[a] == null){
                return false;
            }
        }
        return flag;
    }

    public void put(String key, T value) {
        // гарантированно записываем
        // значение value по ключу key
        if(isKey(key)){
            int ind = hashFun(key);
            while(!slots[ind].equals(key)){
                ind +=step;
                if(ind >= slots.length){
                    int dif = ind - slots.length;
                    ind = dif;
                }
            }
            values[ind] = value;
        }else{
            int index = seekSlot(key);
            values[index] = value;
            slots[index] = key;
        }
    }

    public T get(String key) {
        // возвращает value для key,
        // или null если ключ не найден
        int index = hashFun(key);

        int h = index;
        while(slots[index] != null){
            if(slots[index].equals(key)){
                break;
            }else{
                index+=step;
                if(index >= slots.length){
                    int dif = index - slots.length;
                    index = dif;
                }
            }
        }
        if(index == -1){
            return null;
        }else
            return values[index];
    }
}

