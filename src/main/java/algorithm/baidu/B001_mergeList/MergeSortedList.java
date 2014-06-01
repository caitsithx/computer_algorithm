package algorithm.baidu.B001_mergeList;

/**
 * 数组al[0,mid-1]和al[mid,num-1]是各自有序的，对数组al[0,num-1]的两个子有序段进行merge，
 * 得到al[0,num-1]整体有序。要求空间复杂度为O(1)。注：al[i]元素是支持'<'运算符的。
 * <p/>
 * <p/>
 * 1. 把A1和A2根据首元素比较一下:，
 * 1.1 A1[mid -1] <= A2［0］，直接返回
 * 1.2 否则，分出前后：A1[k] <= A2[0] （可以互换两个list）
 * n=k+1, m=0;
 * <p/>
 * while(n <A1.length) {
 * if(A1[n] <= A2[m]) {
 * n ++;
 * } else ｛
 * swap(A1[n++], A2[m++]);
 * ｝
 * }
 * <p/>
 * foreach A2[m], m < A2.length, copy to merged list.
 * <p/>
 * Created by lixl on 6/1/14.
 */
public class MergeSortedList {
}
