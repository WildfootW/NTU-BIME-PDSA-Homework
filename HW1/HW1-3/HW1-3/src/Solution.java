import java.util.List;
import java.util.Map;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Arrays; 
import java.util.Map;
import java.util.HashMap;

public class Solution {
    public static List<Integer[]> twoSum(Integer[] nums, int t) {
        Map<Integer, Integer> Nums = new HashMap<Integer, Integer>();
        int targetMinusNum;
        List<Integer[]> ans = new LinkedList<>();
        for (int i = 0; i < nums.length; i++){
            targetMinusNum = t - nums[i];
            if (Nums.containsKey(targetMinusNum)){
                Integer[] answer = {0, 0};
                answer[0] = nums[i];
                answer[1] = targetMinusNum;
                Arrays.sort(answer);
                ans.add(answer);
            }
            else{
                Nums.put(nums[i], i);
            }
        }
        return ans;
    }
    
    public static List<int[]> fourSum(int[] a, int tar) {
        List<int[]> ans = new LinkedList<>();
        Map<Integer, Integer> nums = new HashMap<Integer, Integer>();
        //n = index
        for (int n = 0; n < a.length; n++){
            nums.put(n, a[n]);
        }

        for (int m = 0; m < nums.size(); m++){
            for (int i = m+1; i < nums.size(); i++){
                int targets = tar - (nums.get(i) + nums.get(m));
                Map<Integer, Integer> nums_rm = new HashMap<Integer, Integer>(nums);
                nums_rm.remove(i);
                nums_rm.remove(m);
                //create array of numbers
                List<Integer> numsArray = new ArrayList<>();
                for (Map.Entry<Integer, Integer> entry : nums_rm.entrySet()){
                    numsArray.add(entry.getValue());
                }
                Integer[] numsarray = numsArray.toArray(new Integer[0]);
                List<Integer[]>pairs = twoSum(numsarray, targets);
                int[] quad = {0, 0, 0, 0};
                for (int n = 0; n < pairs.size(); n++){
                    quad[0] = nums.get(i);
                    quad[1] = nums.get(m);
                    quad[2] = pairs.get(n)[0];
                    quad[3] = pairs.get(n)[1];
                    Arrays.sort(quad);
                    int diffTimes2 = 0;
                    for (int k = 0; k < ans.size(); k++){
                        int[] cases = ans.get(k);
                        if(!Arrays.equals(cases, quad)){
                        diffTimes2++;
                        }
                    }
                    if (diffTimes2 == ans.size()){
                        ans.add(quad);
                    }
                }
                
            }
        }

        

        

        // //two negative & two positive numbers
        // List<int[]> ans2to2 = new LinkedList<>();
        // //form map of pairs, pair as key item as sum.
        // Map<int[], Integer> posPairMap = new HashMap<int[], Integer>();
        // for (int k = 0; k < posArray.length; k++){
        //     for (int l = k+1; l <posArray.length; l++){
        //         int[] pair = {posArray[k], posArray[l]};
        //         posPairMap.put(pair, posArray[k]+posArray[l]);
        //     }
        // }
        // Map<int[], Integer> negPairMap = new HashMap<int[], Integer>();
        // for (int k = 0; k < negArray.length; k++){
        //     for (int l = k+1; l <negArray.length; l++){
        //         int[] pair = {negArray[k], negArray[l]};
        //         negPairMap.put(pair, negArray[k]+negArray[l]);
        //     }
        // }
        // int iter = 0;
        // Map<Integer, int[]> pospairitem = new HashMap<Integer, int[]>();
        // for (Map.Entry<int[], Integer> entry3 : posPairMap.entrySet()){
        //     pospairitem.put(iter, entry3.getKey());
        //     iter++;
        // }
        // for (Map.Entry<int[], Integer> entry2 : negPairMap.entrySet()){
        //     int target2 = 0-entry2.getValue();
        //     if (posPairMap.containsValue(target2)){
        //         for (int m = 0; m <= target2/2; m++){
        //             int[] targetpair = {m, target2-m};
        //             int[] inv_targetpair = {target2-m, m};
        //             Boolean b = pospairitem.containsValue(targetpair);
        //             if (pospairitem.containsValue(targetpair)){
        //                 int[] pair2to2 = {0, 0, 0, 0};
        //                 pair2to2[0]=entry2.getKey()[0];
        //                 pair2to2[1]=entry2.getKey()[1];
        //                 pair2to2[2]=targetpair[0];
        //                 pair2to2[3]=targetpair[1];
        //                 Arrays.sort(pair2to2);
        //                 int diffTimes2 = 0;
        //                 for (int k = 0; k < ans2to2.size(); k++){
        //                     int[] cases2 = ans2to2.get(k);
        //                     if(!Arrays.equals(cases2, pair2to2)){
        //                     diffTimes2++;
        //                     }
        //                 }
        //                 if (diffTimes2 == ans2to2.size()){
        //                     ans2to2.add(pair2to2);
        //                     ans.add(pair2to2);
        //                 }
        //             }
        //             else if (posPairMap.containsKey(inv_targetpair)){
        //                 int[] pair2to2 = {0, 0, 0, 0};
        //                 pair2to2[0]=entry2.getKey()[0];
        //                 pair2to2[1]=entry2.getKey()[1];
        //                 pair2to2[2]=inv_targetpair[0];
        //                 pair2to2[3]=inv_targetpair[1];
        //                 Arrays.sort(pair2to2);
        //                 int diffTimes2 = 0;
        //                 for (int k = 0; k < ans2to2.size(); k++){
        //                     int[] cases2 = ans2to2.get(k);
        //                     if(!Arrays.equals(cases2, pair2to2)){
        //                     diffTimes2++;
        //                     }
        //                 }
        //                 if (diffTimes2 == ans2to2.size()){
        //                     ans2to2.add(pair2to2);
        //                     ans.add(pair2to2);
        //                 }
        //             }
        //         }
        //     }
        // }

        

        return ans;
    }
    public static void main(String[] args) {
        List<int[]> ans = fourSum(new int[] {-12330562, -26175966, 60267619, -73907691, 1070051, -95268374, 2172984, 22204477, -78355603, -53520691, -46799703, -29363251, -25986550, 59376633, -94873316, 81516118, 17324406, -61608647, -29733317, 64026106, 70549217, -5481569, 32261163, 85829201, -35674826, -55844644, -55371704, 61022815, -3441087, 989080, 8397845, 51636322, 93494714, 99000224, 74926928, 49631922, 36853119, 68473411, -1841523, 80934032, -81710246, -83654053, -50102291, -38940666, 70816130, -83362954, 83837899, 18836944, 82464854, -70673245, -18983548, -98117108, -21623748, -31363333, 61506707, 8048367, -74068850, 21406275, 90491430, 85727089, 50618900, 79785389, 47422516, 4787502, -15293674, -15225140, -30215891, -25553394, -82069892, 8860625, -26252345, 7020641, 55370410, -75394758, 22516677, -93220212, 2139652, 4908673, 8018919, 53214845, 58577320, -88797802, 85536710, -23577294, 5521265, -78393143, 98000911, 66558324, 87317438, -76957740, -17254378, 86305226, -37312695, -19333480, 85872651, 72608113, -52942390, 8354646, -10018971, 56147773, -79886894, -21902968, -72326524, 50032540, 29745375, -588621, -72911396, 46192217, -78078013, -51462949, -74891793, 41382913, -7435206, 63842665, -60818508, -41977983, 83973159, 9010375, 36610161, 61186254, 82293067, 98956350, 5792446, 71261314, 34018216, -33953630, 16996455, -96455198, 88063842, 15485028, -16851341, 30033008, 43593025, 50629996, 7609038, 90950433, 46147154, 59378839, -23512448, -60440065, 52193374, 80367395, 99252391, 28377642, 5490561, 51953089, -97142524, -33102286, -55825823, -14151396, -67183057, 60213716, -17179618, 87318882, -16570743, -8507426, 90007297, 96677325, 57820585, 1633457, -48593986, 85950667, 98800824, -21071052, -53239526, -50503198, -54342933, -12497929, -77203435, -54117508, 2371512, -62293899, -86310987, -60415484, 45520297, -66505574, 19132906, -3673412, 32687936, 81296175, 48066499, -54389735, -39107045, -74549220, -21801427, 29180821, -80183505, -64396422, -87688513, -1793604, -37811915, -56244375, -28427113, 60703862, -81579177, -79627895, 64753553, 45652390, 53186691, 68812261, -76571042, -89276313, -4719511, -81282244, 30959033, -89698621, -38365135, 74255014, 88885193, 45163484, 25915315, -31794286, 36851587, 16656788, 58391570, -42453536, -86882484, -16670332, -96385673, 59666491, -65080520, 72979397, -73942604, -55519013, 20295160, 74148511, -97420675, -80856639, -34052060, 96400878, -83206338, -69799951, 58317652, 68366933, -44310453, -15810906, 4159520, 51071554, 27758711, 64225905, 356963, 94185964, 11671531, -45961277, 17936524, 25733118, -87778472, -27042655, 76921266, -81656055, 7744921, 64826643, 74993506, 87096988, -1766477, -9901911, -52712896, 35679311, 13686515, 67158357, -58568296, -86735807, -4745922, -28872170, 12914978, 95181357, -46004898, -2543311, 21447897, 76414321, 19174816, 47983699, 72334899, -79143239, -6757009, 19492083, -3165067, 37171800, 27071740, -7254845, -37785935, -32265292, 65262748, 49483537, 20795080, -31958503, 73422208, -81859543, -67317143, -83479264, -28469194, -15091842, -2753031, -1011412, 77735655, 91192640, -20826381, -11991452, 59126039, -36934478, 97914617, -515087, 54874746, 7608329, -84244428, -40397415, 96672579, 54792263, -95622568, 51437059, -58642020, 840843, 86258346, 52114928, 77640349, -78187337, -94551787, -46275604, 80625969, -3138208, 36216632, -36709118, -94308688, 89612625, 33232910, -50655119, -88581596, 6632945, -7756650, 3862918, -36958770, 37395906, 77857743, -98487290, -57288380, 8501700, -20985517, -81807199, -92893000, -93497797, -97069226, 57005789, 2170262, 43201469, 86029464, -31433586, -88056723, 37707935, 67524737, 59488848, -91163842, -3720614, -65456290, -36585470, -21076437, 34738870, 60519591, -64765330, 27331762, 12175322, -938945, 39064185, 59591954, 56608510, -81986140, 68628619, -47923441, 88910445, 51482934, -46714526, 3043756, 10216867, 13453156, -49186543, -89541368, -71406478, 80369922, 68829761, 51772309, 57228911, 98964474, 3405095, 63086382, -50390086, 61149122, -55809675, -7516561, 46632368, 43864146, 70678597, 2115815, -30446536, 88628862, 24716414, -33775057, -9194700, 1771717, 87603233, -83560882, 88754989, -98879175, -36680288, 46776998, -76524451, -35970515, -21802643, -81480711, 99604795, -68905432, 16436629, -41240201, -26755192, 82914954, -23956060, -12253327, 23298350, 5351077, -33539442, 88010727, -84414525, -3591127, 71311139, 44450977, 68362697, -53140499, -34782231, 39096996, -64459964, 95355394, -37556727, 41811509, -55960380, 25554595, 46082038, -66245534, -13371241, 83413794, -79649457, -28868367, 2680477, 46882173, 20399386, -86672885, -6897741, 35978557, -64874210, -20129885, 62478468, 73271441, -98119593, -79027260, -11426453, 2768512, 21280857, 20371643, 72058399, 48560257, 75183146, -39211297, 53675723, 40237909, 942835, -23181575, -52362096, 79080371, 99973909, 81446513, -34201075, -14760366, 92931980, -65825579, -6579465, -69723146, -50804082, 23509553, 84422188, 48279359, -29391648, 53567302, 48091951, -61160390, -36792134, -79516763, -16407776, -51867243, 79610031, 18988177, 43533037, -5856895, -2601257, -94175290, -93471034, 58168084, -35695885, -33627069, 78814550, 56560861, -52448718, 42658635, 13647197}, 12203805);
        System.out.print("Output: [");
        for (int[] a: ans) {
            System.out.print(Arrays.toString(a));
            System.out.print(", ");
        }
        System.out.println(']');
    }
}
