class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        int len = flowerbed.length;

        for (int i = 0; i < len; i++) {
            if (flowerbed[i] == 0 &&
               (i == 0 || flowerbed[i - 1] == 0) &&
               (i == len - 1 || flowerbed[i + 1] == 0)) {

                flowerbed[i] = 1;  // Plant the flower
                count++;

                if (count >= n) return true;  // Early exit
            }
        }

        return count >= n;
    
    }
}