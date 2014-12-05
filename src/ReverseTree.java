import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.LinkedBlockingQueue;

public class ReverseTree {
    public static void main(String args[] ) throws Exception {
        
        try (Scanner scanner = new Scanner(System.in)) {

            int num = Integer.parseInt(scanner.nextLine());
            int arr[] = new int[num];
            
            for (int i = 0; i < num; i++) {
                arr[i] = scanner.nextInt();
            }
            
            printReverseLevel(arr);
            
        } catch (Exception e) {
            throw e;
        }
    }
    
    public static void printReverseLevel(int arr[])
    {
        if(arr.length == 0)
            return;
        
        Map<Integer, ArrayList<Integer>> levels = new HashMap<>();
        int i = 0;
        int maxLevel = 0;
        int currentLevel = 1;

        while(i < arr.length && arr[i] != -1)
        {
            i++;
        }
        
        // should have a root element
        assert(i < arr.length);
        // Root level
        ArrayList<Integer> list = new ArrayList<>();
        list.add(i);
        levels.put(currentLevel, list);
        
        Queue<Integer> queue = new LinkedBlockingQueue<>();
        queue.add(i);
        
        while(!queue.isEmpty())
        {
            int element = queue.remove();
            currentLevel += 1;
            
            for(int j = 0; j < arr.length; j++)
            {
                if(arr[j] == element)
                {
                    queue.add(j);
                    
                    ArrayList<Integer> currentList = levels.get(currentLevel);
                    if(currentList == null)
                    {
                        currentList = new ArrayList<Integer>();
                    }
                    currentList.add(j);
                    levels.put(currentLevel, currentList);
                    
                    if(currentLevel > maxLevel)
                    {
                        maxLevel = currentLevel;
                    }
                }
            }
        }
        
        while (maxLevel >= 1)
        {
            ArrayList<Integer> nodes = levels.get(maxLevel);
            maxLevel--;
            
            for(int position : nodes)
            {
                System.out.print(position + " ");
            }
            System.out.println();
        }
    }
}