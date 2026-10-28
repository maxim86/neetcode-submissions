class DynamicArray {
    int size = 0; 
    int capacity = 0; 
    int[] data;
    public DynamicArray(int capacity) {
        this.capacity=capacity;
        this.size = 0;
        data = new int[capacity];
    }

    public int get(int i) {
        return data[i];
    }

    public void set(int i, int n) {
        data[i] = n;
    }

    public void pushback(int n) {
        size++;
        if (size > capacity) {
            resize();
        } 
        data[size - 1] = n;
    }

    public int popback() {
        return data[--size];
    }

    private void resize() {
        capacity = capacity * 2;
        int[] data_new = new int[capacity];
        for (int i = 0; i < data.length; i++) {
            data_new[i] = data[i];
        }
        data = data_new;
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return capacity;
    }
}
