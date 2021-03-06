import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

class loc {
    private int x;
    private int y;

    loc(int x, int y) {
        this.x = x;
        this.y = y;
    }

    int getX() {
        return x;
    }

    int getY() {
        return y;
    }

    boolean equals(loc l) {
        if (l.getY() == this.y) return l.getX() == this.x;
        return false;
    }
}

class locQueue {
    private int maxSize;
    private loc[] queArray;
    private int front;
    private int rear;
    private int nItems;
    //--------------------------------------------------------------
    locQueue(int s)          // constructor
    {
        maxSize = s;
        queArray = new loc[maxSize];
        front = 0;
        rear = -1;
        nItems = 0;
    }
    //--------------------------------------------------------------
    void insert(loc j)   // put item at rear of queue
    {
        if (rear == maxSize - 1)         // deal with wraparound
            rear = -1;
        queArray[++rear] = j;         // increment rear and insert
        nItems++;                     // one more item
    }
    //--------------------------------------------------------------
    loc remove()         // take item from front of queue
    {
        loc temp = queArray[front++]; // get value and incr front
        if (front == maxSize)           // deal with wraparound
            front = 0;
        nItems--;                      // one less item
        return temp;
    }
    //--------------------------------------------------------------
    boolean isEmpty()    // true if queue is empty
    {
        return (nItems == 0);
    }
    //--------------------------------------------------------------
}  // end class Queue

public class Maze {
    private loc curr;
    private loc end;
    private char[][] arr;
    private display disp;
    private locQueue queue;

    Maze(int rows, int cols, loc c, loc e, char[][] m) {
        this.curr = c;
        this.end = e;
        this.arr = m;
        disp = new display(m);
        queue = new locQueue(rows * cols);
        queue.insert(curr);
    }

    private void pause(long m) {
        try {
            Thread.sleep(m);
        } catch (InterruptedException ex) {
            System.out.println("error");
        }
    }

    private char[][] visited(char[][] c, loc l) {
        c[l.getY()][l.getX()] = '.';
        return c;
    }

    private void checkN(char[][] c, loc l) {
        for (int i = 0; i < 4; i++) {
            int y = l.getY();
            int x = l.getX();
            switch (i) {
                case 0:
                    y++; //Check bottom
                    break;
                case 1:
                    x--; //Check left
                    break;
                case 2:
                    y--; //Check top
                    break;
                case 3:
                    x++; //Check right
                    break;
            }
            if (0 <= y && y <= c.length - 1) //Check y bounds
                if (0 <= x && x <= c[0].length - 1) //Check x bounds
                    if (c[y][x] == ' ') { //Check if blank
                        queue.insert(new loc(x, y)); //Insert into the queue
                    }
        }
    }

    private void solve() {
        pause(500);
        boolean run;
        do {
            pause(300);
            curr = queue.remove(); //Replace curr with new curr from top of queue
            run = !curr.equals(end); //Check if we reached the end
            arr = visited(arr, curr); //Change array loc to visited
            checkN(arr, curr); //Insert new empty spots into queue
            disp.update(arr); //Update display
        } while (!queue.isEmpty() && run);
        System.out.println("Stop");
    }

    public static void main(String[] args) throws IOException {
        Maze maze = getMaze();
        maze.solve();
    }

    private static Maze getMaze() throws IOException {
        char[][] c;
        System.out.print("Insert the file name: ");
        String fileName = getString();
        File file = new File("src/" + fileName);
        Scanner scan = new Scanner(file);
        int rows = scan.nextInt();
        int cols = scan.nextInt();
        int sY = scan.nextInt();
        int sX = scan.nextInt();
        int eY = scan.nextInt();
        int eX = scan.nextInt();
        scan.nextLine();
        c = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            String nL = scan.nextLine();
            c[i] = nL.toCharArray();
        }
        return new Maze(rows, cols, new loc(sX, sY), new loc(eX, eY), c);
    }


    private static String getString() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        return br.readLine();
    }
}
