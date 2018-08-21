package gameboard;
import org.apache.commons.lang3.ArrayUtils;

public class TestMonster
{
    public static void main(String[] args) {
        Monster.buildBattleBoard();

        Monster MonstersArray[] = new Monster[4];
        // Monster(int health, int attack, int movement, String name)
        MonstersArray[0] = new Monster(200, 10, 1, "Ducky");
        MonstersArray[1] = new Monster(500, 20, 2, "Vita");
        MonstersArray[2] = new Monster(100, 20, 2, "Ricky");
        MonstersArray[3] = new Monster(300, 10, 2, "Mark");

        Monster.reDrawBoard();


        for(Monster m : MonstersArray) {

            if(m.isAlive()) {
                int arrayItemIndex = ArrayUtils.indexOf(MonstersArray, m);
                m.moveMonster(MonstersArray, arrayItemIndex);

            }
        }
        Monster.reDrawBoard();

    }

}
