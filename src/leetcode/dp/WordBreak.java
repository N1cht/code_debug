package leetcode.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sou1AtLab on 2018/3/18 0018.
 */
public class WordBreak {
    private List<String> temp = new ArrayList<String>();

    public static void main(String[] args) {
        /*"catsanddog"
                ["cat","cats","and","sand","dog"]*/
        String s = "catsanddog";
        List<String> wordDict = new ArrayList<String>();
        wordDict.add("cat");
        wordDict.add("cats");
        wordDict.add("and");
        wordDict.add("andd");
        wordDict.add("og");
        //wordDict.add("sand");
        wordDict.add("dog");

        WordBreak temp = new WordBreak();
        temp.wordBreak(s, wordDict);
    }

    public List<String> wordBreak(String s, List<String> wordDict) {

        List<String> result = new ArrayList<String>();
        int length = s.length();
        if (length == 0) return result;

        partitonString(s, 0, result, wordDict);

        return result;
    }

    private boolean partitonString(String s, int startIndex, List<String> result, List<String> wordDict){
        if(startIndex == s.length()) return true;
        for (int i = startIndex; i < s.length(); i++) {
            System.out.println(s.substring(startIndex, i + 1));
            if (wordDict.contains(s.substring(startIndex, i + 1))){
                temp.add(s.substring(startIndex, i + 1));
                if ( !partitonString(s, i + 1, result, wordDict)){
                    if(temp.size() != 0)
                        temp.remove(temp.size() - 1);
                }else{
                    if (temp.size()!=0) {
                        StringBuffer sb = new StringBuffer(temp.get(0));
                        for (int j = 1; j < temp.size(); j++) {
                            sb.append(" ");
                            sb.append(temp.get(j));
                        }

                        result.add(sb.toString());
                        if(temp.size() != 0)
                            temp.remove(temp.size() - 1);
                    }
                }
            }
        }

        return false;
    }
}
