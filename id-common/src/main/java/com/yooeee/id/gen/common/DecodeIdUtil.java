package com.yooeee.id.gen.common;

/**
 * @author Administrator
 * @date 2018/4/2
 */
public final  class DecodeIdUtil {


    public static long[] decode(long id){

        long[] result = new long[6];

        result[0] = id & Constants.GENE_MASK;
        result[1] = (id >>> 0x6) & Constants.SEQ_MASK;
        result[2] = (id >>> 0x10) & 0x3;
        result[3] = (id >>> 0x12) & Constants.TYPE_MASK;
        result[4] = (id >>> 0x13) & Constants.APP_MASK;
        result[5] = (id >>> 0x16)+Constants.EPOCH;
        return  result;
    }


    public static void main(String[] args) {

        /**
         timestamp=1522664516019
         seq=1
         appid=1
         type=1
         gene=50
         epoch=233829541362
         980752180653588786
         */

        long id = 981013521520001074L;




        long[] ids = decode(id);
        for (int i = 0; i < ids.length; i++) {
            System.out.println(ids[i]);
        }
    }


}
