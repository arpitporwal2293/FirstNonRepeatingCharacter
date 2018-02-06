import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FirstNonRepeatingCharacter {

	public static Map<Character,Node> freeNodeMap(char[] arr){
		Map<Character,Node> nodeMap = new HashMap<>();
		for(int i=0;i<arr.length;i++){
			if(nodeMap.containsKey(arr[i])){
				Node node = nodeMap.get(arr[i]);
				node.count++;
				nodeMap.put(arr[i], node);
			}else{
				Node node = new Node();
				node.count=1;
				node.index = i;
				nodeMap.put(arr[i], node);
			}
		}
		return nodeMap;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		char[] arr = str.toCharArray();
		Map<Character,Node> nodeMap = freeNodeMap(arr);
		int minIndex = arr.length-1;
		for(Character c: nodeMap.keySet()){
			Node node = nodeMap.get(c);
			if(node.count==1){
				if(minIndex>node.index){
					minIndex = node.index;
				}
			}
		}
		System.out.println(arr[minIndex]);
	}

}
