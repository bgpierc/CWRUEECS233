public class LinkedNode<T extends Comparable <T>>{
	private T data;
	private LinkedNode link;
	public void setData(T data){
		this.data = data;
	}
	public T getData(){
		return this.data;
	}
	public LinkedNode getLink(){
		return this.link;
	}
	public void setLink(LinkedNode link){
		this.link = link;
	}
	public void addAfterThis(T data){
		link = new LinkedNode(data,this.link);
	}
	public LinkedNode copy(LinkedNode begin){
		LinkedNode newHead;
		LinkedNode newTail;
		if(begin.link == null){
			return new LinkedNode(this.data,null);
		}
		newHead = new LinkedNode(begin.data, null);
		newTail = newHead;
		while(begin.getLink() != null){
			begin = begin.getLink();
			newTail.addAfterThis(begin.getData());
			newTail = newTail.getLink();
		}
		return newHead;
	}
	public static int length(LinkedNode head){
		LinkedNode cursor = head;
		int sum = 0;
		while(cursor != null){
			sum++;
			cursor = cursor.getLink();
		}
		return sum;
	}
	public String toString(){
		return this.getData().toString();
	}
	
   public void removeAfter(){
   	this.link = link.getLink();
   }
   public LinkedNode(T data, LinkedNode link){
	this.data = data;
	this.link = link;
   }
}