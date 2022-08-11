package music_player;



public class DLLA {
	class Node{  
        Song s;  
        Node previous;  
        Node next;  
          
        public Node(Song s) {  
            this.s=s;  
        }  
    }  
	
	
	 Node head, tail = null; 
	 
	 private int size;
	 
	 public int getSize() {
		 return size;
	 }
	 
	 private long totLength;
	 
	 public long getLength() {
		 return totLength;
	 }
	 
	 
	 public void addNode(Song s) {  
	        //Create a new node  
	        Node newNode = new Node(s);  
	          
	        //If list is empty  
	        if(head == null) {  
	            //Both head and tail will point to newNode  
	            head = tail = newNode;  
	            //head's previous will point to null  
	            head.previous = null;  
	            //tail's next will point to null, as it is the last node of the list  
	            tail.next = null;
	            size++;
	            totLength+=s.getLength();
	        }  
	        else {  
	            //newNode will be added after tail such that tail's next will point to newNode  
	            tail.next = newNode;  
	            //newNode's previous will point to tail  
	            newNode.previous = tail;  
	            //newNode will become new tail  
	            tail = newNode;  
	            //As it is last node, tail's next will point to null  
	            tail.next = null;
	            size++;
	            totLength+=s.getLength();
	        }  
	    }
	 
	 public Song remove(Song a) {
			if(getSize()>0) {
				Node current = head;
				while(current!=null) {
					Song inList = current.s;
					if(inList.equals(a)) {
						//Unlinking(removing) node
						Node cPrevious = current.previous;
						Node cNext = current.next;
						cPrevious.next=cNext;
						cNext.previous=cPrevious;
						size--;
						totLength-=inList.getLength();
						return inList;
					}
					current=current.next;
				}
			}
			return null;
		}
	 
		public void sortTitle() {
			Node current = null, index = null;  
		    Song temp;  
		 
		    if(head == null) {  
		      return;  
		    }  
		    else {   
		     for(current = head; current.next != null; current = current.next) {  
		        for(index = current.next; index != null; index = index.next) {  
		        	SongTitleComparator stc=new SongTitleComparator();
		           if(stc.compare(current.s,index.s)==1) {  
		                temp = current.s;  
		                current.s = index.s;  
		                index.s = temp;  
		            }  
		         }  
		       }  
		    }  
		}
		
		public void sortDuration() {
			Node current = null, index = null;  
		    Song temp;  
		 
		    if(head == null) {  
		      return;  
		    }  
		    else {   
		     for(current = head; current.next != null; current = current.next) {  
		        for(index = current.next; index != null; index = index.next) {  
		           if(current.s.getDuration() < index.s.getDuration()) {  
		                temp = current.s;  
		                current.s = index.s;  
		                index.s = temp;  
		            }  
		         }  
		       }  
		    }  
		}

		
		
}


