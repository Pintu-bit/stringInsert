import java.util.Scanner;

import static java.lang.Math.abs;

class StringInsert {
    private
    char[] str;
    int size;

    public StringInsert(char[] str, int size) {
        this.str = new char[size];
        for (int i = 0; i < size; i++) {
            this.str[i] = str[i];
        }
        this.size = size;
    }

    public StringInsert(){
        this.str = new char[8];
        this.size = 0;
    }

    void viewAll(){
        for(int i = 0; i < size; i++){
            System.out.print(str[i]);
        }
    }

    int size(){
        return size;
    }

    void viewUpTo(int position){
        if(position < size){
            for(int i = 0; i < position; i++){
                System.out.print(str[i]);
            }
        }else{
            System.out.println("Invalid position");
        }

    }

    void viewFrom(int start){
        if(start < size){
            for(int i = start; i < size; i++){
                System.out.print(str[i]);
            }
        }else{
            System.out.println("Invalid position");
        }

    }

    void viewInBetween(int start, int end){
        if(start < size && end < size && start < end){
            for(int i = start; i <= end; i++){
                System.out.print(str[i]);
            }
        }else{
            System.out.println("Invalid position");
        }

    }

    String replaceAllCharacter(char newChar, char oldChar){
        int flag = this.size;
        for (int i = 0; i < size; i++) {
            if (this.str[i] == oldChar) {
                this.str[i] = newChar;
                flag-- ;
            }
        }
        if(flag == this.size){
             return " Character does not exist ";
        }else{
            return this.convertToString();
        }
    }

    String convertToString(){
       return String.valueOf(str);
    }

    String convertToString(char[] str){
        return String.valueOf(str);
    }

    String replaceFirstCharacter(char newChar, char oldChar) {
        boolean flag = false;

        for (int i = 0; i < size; i++) {
            if (this.str[i] == oldChar) {
                this.str[i] = newChar;
                flag = true;
                break;
            }else{
                flag = false;
            }
        }
        if(!flag){
            return " Character does not exist ";
        }else{
            return this.convertToString();
        }
    }


    String replaceLastCharacter(char newChar, char oldChar) {
        boolean flag = false;
        for (int i = this.size-1; i >= 0; i--) {
            if (this.str[i] == oldChar) {
                this.str[i] = newChar;
                flag = true;
                break;
            }

        }
        if(!flag){
            return " Character does not exist ";
        }else{
            return this.convertToString();
        }
    }

    String replaceByNumber(int index, char oldChar) {
        this.str[index-1] = oldChar;
        return this.convertToString();
    }

    String replaceStr(String oldStr, String newStr) {
        int index = 0,idx = 0;
        boolean flag = false;
        for(int i = 0; i < size; i++) {
            if (this.str[i] == oldStr.charAt(idx)) {
                idx++;
                index = i;
            } else {
                idx = 0;
                index = 0;
            }
            if(idx == oldStr.length()){
                flag = true;
                break;
            }
        }
        idx = 0;
        for(int i = index-oldStr.length()+1; i <= newStr.length(); i++){
            this.str[i] = newStr.charAt(idx++);
        }

        return this.convertToString();
    }

    String addAtIndex(int index, char newChar) {
         char tmpch[] = new char[this.size+1];
         for(int i = 0,j = 0; i < size+1; i++){
             if(index-1 == i){
                 tmpch[i] = newChar;
                 i++;
             }
             tmpch[i] = this.str[j++];
         }
         this.str = new char[this.size+1];
         this.size++;
         for(int i = 0; i < size; i++){
          this.str[i] = tmpch[i];
         }
         return this.convertToString();
    }

    boolean find(String str){
        int idx = 0;
        boolean flag = false;
       for(int i = 0; i < size; i++){
           if(this.str[i] == str.charAt(idx)){
               idx++;
           }else{
               idx = 0;
           }
           if(idx == str.length()){
               flag = true;
               break;
           }
       }
       return flag;
    }

    String addString(String tmpstr){
        char tmpCh[] = new char[tmpstr.length()+this.size];
        int idx = 0;
        for(int i = 0; i < size+tmpstr.length(); i++){
            if(i < this.size){
                tmpCh[i] = this.str[i];
            }else{
                tmpCh[i] = tmpstr.charAt(idx++);
           }
        }
        this.str = new char[this.size+tmpstr.length()];

        for(int i = 0; i < size+tmpstr.length(); i++){
            this.str[i] = tmpCh[i];
        }
        this.size += tmpstr.length();
        return this.convertToString();
    }



    String removeSpace(){
        boolean flag = false;
        int idx = 0;
        for(int i = 0; i < size-idx; i++){
            if(this.str[i] == ' '){
               flag = true;
               idx +=1;
            }
            if(flag){
                this.str[i] = this.str[i+1];
            }
        }
        char tmp[] = new char[this.size-idx];
        for(int i = 0; i < size-idx; i++){
            tmp[i] = this.str[i];
        }
        this.str = new char[this.size-idx];
        for(int i = 0; i < size-idx; i++){
            this.str[i] = tmp[i];
        }
        this.size -= idx;
        return this.convertToString();
    }

    String lowerCase(){
        for(int i = 0; i < size; i++){
            if(this.str[i] >= 'A' && this.str[i] <= 'Z'){
                this.str[i] += 32;
            }

        }
        return this.convertToString();
    }

    String upperCase(){
        for(int i = 0; i < size; i++){
            if(this.str[i] > 98 ){
                this.str[i] -= 32;
            }

        }
        return this.convertToString();
    }

    boolean isSpecialCharacter(){
        boolean flag = false;
        for(int i = 0; i < size; i++){
            if((this.str[i] >= 'A' && this.str[i] <= 'Z') || (this.str[i] >= 'a' && this.str[i] <= 'z')){
                flag = false;
            }else{
                flag = true;
                break;
            }
        }
        return flag;
    }


    int countSpecialCharacter(){
        int count = 0;
        for(int i = 0; i < size; i++){
            if((this.str[i] >= 'A' && this.str[i] <= 'Z') || (this.str[i] >= 'a' && this.str[i] <= 'z')){
                count++;
            }
        }
        return this.size-count;
    }

    String removeSpecialCharacter(){
        boolean flag = false;
        int idx = 0;
        int count = this.countSpecialCharacter();
        if(count > 0) {
            char ch[] = new char[this.size - count + 1];
            for (int i = 0; i < size; i++) {
                if ((this.str[i] >= 'A' && this.str[i] <= 'Z') || (this.str[i] >= 'a' && this.str[i] <= 'z')) {
                    ch[idx++] = this.str[i];
                }
            }
            this.str =  new char[this.size - count];
            for (int i = 0; i < size - count; i++) {
                 this.str[i] = ch[i];
            }
            this.size -= count;
        }
        return this.convertToString();
    }


    String extractSpecialCharacter(){
        int count = this.countSpecialCharacter(),idx = 0;
        if(count > 0) {
            char tmp[] = new char[count];

            for(int i = 0; i < size; i++){
                if((this.str[i] > 90 && this.str[i] < 97 ) || (this.str[i] < 65 || this.str[i] > 122)){
                    tmp[idx++] = this.str[i];
                }
            }
            return convertToString(tmp);
        }else{
              return null;
        }
    }

    boolean containNumber(){
        boolean flag = false;
        for(int i = 0; i < size; i++){
            if(this.str[i] >= 48 && this.str[i] <= 57){
                flag = true;
                break;
            }else{
                flag = false;
            }
        }
        return flag;
      }

      int countNumber(){
        int count = 0;
        for(int i = 0; i < size; i++){
            if(this.str[i] >= 48 && this.str[i] <= 57){
                count++;
            }
        }
        return count;
      }

    String extractNumber(){
        int count = this.countNumber();
        char[] ch = new char[count];
        if(count > 0) {
            for (int i = 0; i < size; i++) {
                if(this.str[i] >= 48 && this.str[i] <= 57){
                    ch[i] = this.str[i];
                }
            }
        }
        return convertToString(ch);
    }

    char charAt(int index){
        return this.str[index];
    }

    int indexOf(char ch){
        for(int i = 0; i < size; i++){
            if(this.str[i] == ch){
                return i;
            }
        }
        return -1;
    }

    boolean compareTo(String str){
        boolean flag = false;
        for(int i = 0; i < size; i++){
            if(this.str[i] == str.charAt(i)){
              flag = true;
            }else{
                flag = false;
                break;
            }
        }
        return flag;
    }

    boolean compareToIgnoreCase(String str){
        boolean flag = false;
        if(str.length() == this.size) {
            for (int i = 0; i < size; i++){
                if (abs(this.str[i] - str.charAt(i)) == 32 || abs(this.str[i] - str.charAt(i)) == 0)
                    flag = true;
                else {
                    flag = false;
                    break;
                }
            }
            return flag;
        }else{
            System.out.println(" size is not same ");
            return false;
        }

    }
    int wordCount(){
        int count = 1;
        for(int i = 0; i < size; i++){
            if(this.str[i] == ' '){
                count++;
            }
        }
        return count;
    }

    String subString(int start, int end){
        char tmpCh[] = new char[end-start];
        int idx = 0;
        for(int i = start; i < end; i++){

            tmpCh[idx++] = this.str[i];
        }

        return this.convertToString(tmpCh);
    }
    int wordCount(char ch){
        int count = 1;
        for(int i = 0; i < size; i++){
            if(this.str[i] == ch){
                count++;
            }
        }
        return count;
    }

    void split(char ch) {
        int wordCount = this.wordCount(ch);
        if (wordCount == 1) {
            System.out.println("Splitting character is not found ");
        } else {
            String result[] = new String[this.wordCount(ch)];
            int start = 0, end = 0, idx = 0;
            for (int i = 0; i < size; i++) {
                if (this.str[i] == ch) {
                    start = end;
                    end = i;
                    result[idx++] = this.subString(start, end);
                    //System.out.println(start+" "+end);
                }
            }

            result[idx++] = this.subString(end, this.size);
            for (int i = 0; i < result.length; i++) {
                System.out.println(result[i]);
            }
        }
    }
}

