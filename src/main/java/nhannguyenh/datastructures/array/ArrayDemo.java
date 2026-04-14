package nhannguyenh.datastructures.array;

public class ArrayDemo {

    public int getElementAtIndex(int index, int[] arrays){
        return arrays[index];
    }

    public String getAllElements(int[] arrays) {
        StringBuilder elementArrays = new StringBuilder();
        for (int index = 0; index < arrays.length; index++) {
            if (index == arrays.length - 1) {
                elementArrays.append(arrays[index]);
            } else {
                elementArrays.append(arrays[index]).append(", ");
            }
        }
        return elementArrays.toString();
    }
}
