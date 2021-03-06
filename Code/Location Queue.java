class Link
{
    public Location dData;                // data item
    public Link next;                 // next link in list
    // -------------------------------------------------------------
    public Link(Location d)               // constructor
    { dData = d; }
    // -------------------------------------------------------------
    public void displayLink()         // display this link
    { System.out.print(dData + " "); }
    // -------------------------------------------------------------
}  // end class Link
---------------------------------------------------------------------
class FirstLastList
{
    private Link first;               // ref to first item
    private Link last;                // ref to last item
    // -------------------------------------------------------------
    public FirstLastList()            // constructor
    {
        first = null;                  // no items on list yet
        last = null;
    }
    // -------------------------------------------------------------
    public boolean isEmpty()          // true if no links
    { return first==null; }
    // -------------------------------------------------------------
    public Location deleteFirst()         // delete first link
    {                              // (assumes non-empty list)
        Location temp = first.dData;
        if(first.next == null)         // if only one item
            last = null;                // null <-- last
        first = first.next;            // first --> old next
        return temp;
    }
    // -------------------------------------------------------------
    public void insertLast(Location dd) // insert at end of list
    {
        Link newLink = new Link(dd);   // make new link
        if( isEmpty() )                // if empty list,
            first = newLink;            // first --> newLink
        else
            last.next = newLink;        // old last --> newLink
        last = newLink;                // newLink <-- last
    }
    // -------------------------------------------------------------
    public void displayList()
    {
        Link current = first;          // start at beginning
        while(current != null)         // until end of list,
        {
            current.displayLink();      // print data
            current = current.next;     // move to next link
        }
        System.out.println("");
    }
    // -------------------------------------------------------------
}  // end class FirstLastList
    ------------------------------------------------------------------
    /**
 * Write a description of class LocationQueue here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
class LocationQueue
{
    private FirstLastList theList;
    //--------------------------------------------------------------
    public LocationQueue(){                // constructor
    	theList = new FirstLastList(); 
    }  // make a 2-ended list
    //--------------------------------------------------------------
    public void insert(Location j){        // insert, rear of queue
    	theList.insertLast(j); 
     }
    //--------------------------------------------------------------
    public Location remove(){              // remove, front of queue
    	return theList.deleteFirst();  
      }
    //--------------------------------------------------------------
    public boolean isEmpty(){          // true if queue is empty
    	return theList.isEmpty(); 
    }
    //--------------------------------------------------------------
    public void displayQueue(){
        System.out.print("Queue (front-->rear): ");
        theList.displayList();
    }
    //--------------------------------------------------------------
}  // end class LinkQueue
    
