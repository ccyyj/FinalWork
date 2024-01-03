package com.fc.exercise;

import java.util.ArrayList;

public class Cart implements java.io.Serializable{
    private static final long serialVersionUID = -442569050914898900L;
    private ArrayList<Goods> goodslist=new ArrayList<Goods>();
    public ArrayList<Goods> getGoodslist() {
        return goodslist;
    }
    public void setGoodslist(ArrayList<Goods> goodslist) {
        this.goodslist = goodslist;
    }
    //循环遍历并累加集合中商品的数量，得到购物车总数量
    public int getGcount() {
        int count=0;
        for(int i=0;i<goodslist.size();i++) {
            count+=goodslist.get(i).getGcount();
        }
        return count;
    }
    //循环遍历并累加集合中商品的小计金额，得到购物车商品总额
    public double getTotal() {
        double sum=0;
        for(int i=0;i<goodslist.size();i++) {
            sum+=goodslist.get(i).getGprice()*goodslist.get(i).getGcount();
        }
        return sum;
    }
    //判断是否存在指定gid对应的商品，如果有则返回索引值
    public int check(int gid) {
        int index=-1;
        for(int i=0;i<goodslist.size();i++) {
            if(goodslist.get(i).getGid()==gid) {
                index=i;
                break;
            }
        }
        return index;
    }
    //将指定的商品加入购物车
    public void addGoods(Goods goods) {
        int gid=goods.getGid();
        int index=check(gid);//判断购物车是否存在该商品
        if(index==-1) {//若商品不存在，则直接添加到商品集合中
            goodslist.add(goods);
        }
        else {//若商品存在，则添加对应的数量
            int num=goodslist.get(index).getGcount()+goods.getGcount();
            goodslist.get(index).setGcount(num);
        }
    }
}
