/**
 *    Copyright 2009-2020 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
/**
 * 2020/4/9 下午5:51
 * aiguoxin
 * 说明: 242-有效的字母异位词
 */
public class SameCharacter {

    public boolean isAnagram(String s, String t) {
        char z = 'z';
        char[] all = new char[z+1];
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();
        for(int i=0; i< sc.length; i++){
            all[sc[i]] += 1;
        }
        for(int i=0; i< tc.length; i++){
            all[tc[i]] -= 1;
        }

        for(int i=0; i< sc.length; i++){
            if(all[sc[i]] != 0) {
                return false;
            }
        }

        for(int i=0; i< tc.length; i++){
            if(all[tc[i]] != 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args){
        String s = "zlap";
        String t = "kcqx";
        SameCharacter sameCharacter = new SameCharacter();
        boolean result = sameCharacter.isAnagram(s,t);
        System.out.println("result = "+ result);
    }

}
