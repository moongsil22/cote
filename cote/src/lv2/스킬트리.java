package lv2;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;

public class 스킬트리 {

    public int solution(String skill, String[] skill_trees) {
        int answer = -1;

        List<Character> list = new ArrayList<>();

        for (int i = 0; i < skill.length(); i++) {
            list.add(skill.charAt(i));
        }

        int cnt = 0;
        for (int i = 0; i < skill_trees.length; i++) {
            int idx = -1, beforeIdx = -1;
            boolean isCnt = true;
            boolean isFirst = true;
            for (int j = 0; j < skill_trees[i].length(); j++) {
                if (list.contains(skill_trees[i].charAt(j))) {
                    if (idx >= 0) {
                        beforeIdx = idx;
                    }
                    idx = list.indexOf(skill_trees[i].charAt(j));
                    if (isFirst) {
                        if (idx > 0) {
                            isCnt = false;
                            break;
                        }
                    }
                    if (idx < beforeIdx || (beforeIdx !=-1 && idx - beforeIdx > 1) ) {
                        isCnt = false;
                        break;
                    }
                    isFirst = false;
                }
            }
            if (isCnt) {
                cnt++;
            }
        }

        answer = cnt;

        return answer;
    }

    public int solution2(String skill, String[] skill_trees) {
        int answer = 0;
        ArrayList<String> skillTrees = new ArrayList<String>(Arrays.asList(skill_trees));
        //ArrayList<String> skillTrees = new ArrayList<String>();
        Iterator<String> it = skillTrees.iterator();

        while (it.hasNext()) {
            if (skill.indexOf(it.next().replaceAll("[^" + skill + "]", "")) != 0) {
                it.remove();
            }
        }
        answer = skillTrees.size();
        return answer;
    }    

    @Test
    public void test() {
        스킬트리 solution = new 스킬트리();

        assertEquals(4, solution.solution("CBD", new String[] { "BACDE", "CBADF", "AECB", "BDA","AEF","CED","AB" , "CEB" }));
    }

    @Test
    public void test2() {
        스킬트리 solution = new 스킬트리();

        assertEquals(4, solution.solution2("CBD", new String[] { "BACDE", "CBADF", "AECB", "BDA","AEF","CED","AB" , "CEB" }));
    }    

}
