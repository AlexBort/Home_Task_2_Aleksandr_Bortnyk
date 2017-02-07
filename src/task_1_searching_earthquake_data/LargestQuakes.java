package task_1_searching_earthquake_data;

import java.util.ArrayList;

/*
*
 * Created by User on 01.02.2017.

*/


public class LargestQuakes {

    public static void main (String [] args) {
        findLargestQuakes();
    }


    public static ArrayList<QuakeEntry> getLargest(ArrayList<QuakeEntry> quakeData, int howMany) {
        ArrayList<QuakeEntry> tempList = new ArrayList<QuakeEntry>(quakeData.subList(0,quakeData.size()));
        ArrayList<QuakeEntry> returnList = new ArrayList<QuakeEntry>();
        while(tempList.size()!=0&&returnList.size()<howMany){
            int index = indexOfLargest(tempList);
            returnList.add(tempList.remove(index));
        }

        return returnList;
    }

    public static void findLargestQuakes() {
        EarthQuakeParser parser = new EarthQuakeParser();
     //   String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summ..";
      String  source = "data/nov20quakedatasmall.atom";
        ArrayList<QuakeEntry> list = parser.read(source);
        System.out.println("read data for "+list.size());
        ArrayList<QuakeEntry> largestList = getLargest(list,5);

        for(int k=0; k < largestList.size(); k++){
            QuakeEntry entry = largestList.get(k);
            System.out.printf(" %s\n",entry);
        }
        System.out.println("number found: "+largestList.size());
    }

    public static int indexOfLargest(ArrayList<QuakeEntry> data){
        int largestIndex=0;
        double largestMagnitude = 0;
        for(int i=0;i<data.size();i++){
            if(data.get(i).getMagnitude()>largestMagnitude){
                largestMagnitude = data.get(i).getMagnitude();
                largestIndex = i;
            }
        }
        return largestIndex;
    }

}

