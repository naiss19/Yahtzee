public class Dice {
    private int num;
    private boolean isSaved;

    public Dice() {
        this.num = 1;
        this.isSaved = false;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public boolean isSaved() {
        return isSaved;
    }

    public void setSaved(boolean isSaved) {
        this.isSaved = isSaved;
    }
}
