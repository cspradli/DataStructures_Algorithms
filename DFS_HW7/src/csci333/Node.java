/**
 * HW 7 - Depth First Search CSCI 333 - Alg & Data Structures
 * 
 * @author Caleb Spradlin
 * @version 04.22.20
 * 
 * Node class to store all information about one node
 * 
 */
package csci333;

public class Node {

    private int name;
    private int parent;
    private int d;
    private int f;
    private int color;

    /**
     * Sets all private data fields initiallu
     * 
     * @param name of node
     */
    public Node(int name) {
        this.name = name;
        this.parent = -1;
        this.d = 0;
        this.f = 0;
        this.color = 0;
    }

    /**
     * Setter for name
     * 
     * @param name
     */
    public void setName(int name) {
        this.name = name;
    }

    /**
     * Parent setter
     * 
     * @param parent
     */
    public void setParent(int parent) {
        this.parent = parent;
    }

    /**
     * Set D timestamp
     * 
     * @param d
     */
    public void setD(int d) {
        this.d = d;
    }

    /**
     * Set F timestamp
     * 
     * @param f
     */
    public void setF(int f) {
        this.f = f;
    }

    /**
     * Set color of node
     * 
     * @param color
     */
    public void setColor(int color) {
        this.color = color;
    }

    /**
     * Get the name of this node
     * 
     * @return name
     */
    public int getName() {
        return this.name;
    }

    /**
     * Get the parent of this node
     * 
     * @return parent
     */
    public int getParent() {
        return this.parent;
    }

    /**
     * Get the d timestamp
     * 
     * @return d
     */
    public int getD() {
        return this.d;
    }

    /**
     * Get the f timestamp
     * 
     * @return
     */
    public int getF() {
        return this.f;
    }

    /**
     * Get the color of this node
     * 
     * @return color
     */
    public int getColor() {
        return this.color;
    }

    @Override
    public String toString() {
        String fmtout = String.format("%8s%2d\n%8s%2d\n%8s%2d\n%8s%2d\n%8s%2d\n", "Name: ", this.name, "Parent: ",
                this.parent, "d: ", this.d, "f: ", this.f, "Color: ", this.color);
        return fmtout;
    }

}
