class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int maxSpeed = 0;
        for (int p : piles) maxSpeed = Math.max(maxSpeed, p);
        int minSpeed = 1; 
        int bestSpeed = maxSpeed;

        while (minSpeed <= maxSpeed) {
            int speed = minSpeed + (maxSpeed - minSpeed) / 2;
            long time = getHours(piles, speed);
            if (time <= h) {
                bestSpeed = speed;
                maxSpeed = speed - 1;
            } else {
                minSpeed = speed + 1;
            }
        }

        return bestSpeed;
    }

    long getHours(int[] pile, int k) {
        long result = 0;

        for (int i = 0; i < pile.length; i++) {
            result += (pile[i] + k - 1L) / k;
        }

        return result;
    }
}