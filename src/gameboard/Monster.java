package gameboard;
import java.util.Arrays;

public class Monster
{
    private int health = 20;
    private int attack = 10;
    private int movement = 2;

    private boolean alive = true;

    public String name = "Bucky";
    public char charName = 'B';
    public int xPosition = 0;
    public int yPosition = 0;
    public int numOfMonster = 0 ;

    public int getHealth()
    {
        return health;
    }

    public int getAttack()
    {
        return attack;
    }

    public int getMovement()
    {
        return movement;
    }

    public boolean isAlive()
    {
        return alive;
    }

    public void setHealth(int decreaseHealth)
    {
        health = health - decreaseHealth;
        if(health < 0) {
            alive = false;
        }
    }

    public void setHealth(double decreaseHealth)
    {
        health =  health - (int) decreaseHealth;
        if(health < 0) {
            alive = false;
        }
    }

    public void setMovement(int movement)
    {
        this.movement = movement;
    }

    public void setAttack(int attack)
    {
        this.attack = attack;
    }

    public void setAlive(boolean alive)
    {
        this.alive = alive;
    }

    static char[][] battleBoard = new char[10][10];

    public Monster(int health, int attack, int movement, String name) {
        this.health = health;
        this.attack = attack;
        this.movement = movement;
        this.name = name;

        int xMaxSpace = battleBoard.length - 1;
        int yMaxSpace = battleBoard[0].length - 1;

        int xRandNum, yRandNum;
        System.out.println("For monster " + name) ;
        do
        {
            xRandNum = (int) (Math.random() * xMaxSpace);
            yRandNum = (int) (Math.random() * yMaxSpace);
        } while(battleBoard[xRandNum][yRandNum] != '*');

        this.xPosition = xRandNum;
        this.yPosition = yRandNum;
        System.out.println(this.yPosition + " " + this.xPosition);

        this.charName = name.charAt(0);
        battleBoard[this.yPosition][this.xPosition] = charName;
        numOfMonster++;
    }

    public Monster() {
        numOfMonster++;
    }

    public static void buildBattleBoard() {

        for(char[] row : battleBoard) {
            Arrays.fill(row, '*');
            //System.out.println(row);

        }
    }

    public static void reDrawBoard() {

        int k = 1;
        while(k <= 30) {
            System.out.print("-");
            k++;
        }
        System.out.println();

        for(int i = 0; i < battleBoard.length; i++) {
            for(int j = 0; j < battleBoard[i].length; j++) {
                System.out.print("|" + battleBoard[i][j] + "|");
            }
            System.out.println();
        }

        k = 1;
        while(k <= 30) {
            System.out.print("-");
            k++;
        }
        System.out.println();
    }

    public void moveMonster(Monster[] monster, int arrayItemIndex) {

        boolean isSpaceOpen = true;

        int maxXspace = battleBoard.length - 1;
        int maxYspace = battleBoard[0].length - 1;

        while(isSpaceOpen) {

            int randDirection = (int) (Math.random() * 4);
            int randMovement = (int) (Math.random() * (this.getMovement() + 1));

            battleBoard[this.yPosition][this.xPosition] = '*';

            System.out.println(randDirection + " " + randMovement);
            //Moving towards north
            if(randDirection == 0) {

                if((this.yPosition - randMovement) < 0) {
                    this.yPosition = 0;
                }else {
                    this.yPosition -= randMovement;
                }
                //Moving towards east
            } else if(randDirection == 1) {

                if((this.xPosition + randMovement) > maxXspace) {
                    this.xPosition = maxXspace;
                }else {
                    this.xPosition += randMovement;
                }
                //Moving towards south
            } else if(randDirection == 2) {

                if((this.yPosition + randMovement) > maxYspace) {
                    this.yPosition = maxYspace;
                }else {
                    this.yPosition += randMovement;
                }
                //Moving towards west
            } else {
                if((this.xPosition - randMovement) < 0) {
                    this.xPosition = 0;
                } else {
                    this.xPosition -= randMovement;
                }

            }

            for(int i = 0; i < monster.length; i++){

                if(i == arrayItemIndex){
                    continue;
                }

                if(onMySpace(monster, i, arrayItemIndex)){
                    isSpaceOpen = true;
                    break;
                }else{
                    isSpaceOpen = false;
                }
            }

        } //End of WHILE loop

        battleBoard[this.yPosition][this.xPosition] = this.charName;

    } //End of moveMonster method

    public boolean onMySpace(Monster[] monster, int indexChk1, int indexChk2){
        if((monster[indexChk1].xPosition == monster[indexChk2].xPosition) && (monster[indexChk1].yPosition == monster[indexChk2].yPosition)){
            return true;
        }else {
            return false;
        }
    }

}
