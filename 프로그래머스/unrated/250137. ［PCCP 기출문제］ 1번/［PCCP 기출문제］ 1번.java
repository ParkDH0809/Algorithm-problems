class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int max_health = health;
        int time = 0;
        int attack_count = 0;
        int health_count = 0;
        while(attack_count < attacks.length) {
            if(attacks[attack_count][0] == time) {
                health -= attacks[attack_count++][1];
                if(health <= 0)
                    return -1;
                time++;
                health_count = 0;
                continue;
            }
            
            if(health < max_health) {
                health += bandage[1];
                health_count++;
                if(health_count == bandage[0]) {
                    health += bandage[2];
                    health_count = 0;
                }
            }
                
            
            if(health > max_health)
                health = max_health;
            
            time++;
        }
        return health;
    }
}