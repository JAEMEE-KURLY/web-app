<template>
  <div class="container">
   <h3>대시보드</h3>
    <button class="btn btn-success" @click="moveCategory()" >품목 관리</button> &nbsp;
    <button class="btn btn-success" @click="moveSite()">대상 사이트 관리</button>
  <div class="container">
    <select v-model="selectedItem" @change="onChange()">
      <option v-for="item in itemList" :key="item" :value="item">{{item}}</option>
    </select>
    <label>{{selectedItem}}</label>
    <table class="table">
      <thead>
        <tr>
          <th v-for="site in sites" v-bind:key="site.id"> {{site.siteName}}최저가</th>
        </tr>
      </thead>
      <tbody>
        <tr> 
          <td v-for="price in priceInfo" v-bind:key="price.id">{{price.minV}}</td>
        </tr> 
      </tbody>
    </table>
  </div>

  </div>
</template>

<script>
import PriceService from '../service/PriceService';
export default {
  name: "DashBoard",
  data(){
    return {
      itemList:[],
      priceInfo:[],
      selectedItem:'사과',
      sites:[]
    }
  },
  methods:{
    refreshDashboard(){
      this.sites = []
      this.itemList = []
      this.priceInfo = []
      PriceService.retrieveAllPrices().then((res)=>{
        let item = res.data.filter((x) =>x.categoryName.includes(this.selectedItem))
        let k_item = item.filter((x)=> x.companyName.includes('kurly'))[0]
        let o_item = item.filter((x) => !x.companyName.includes('kurly'))
        this.sites.push({id: k_item.id, siteName: k_item.companyName})
        this.priceInfo.push({id:k_item.id, minV: k_item.minPrc})

        o_item.forEach(e => this.sites.push({id: e.id, siteName: e.companyName}))
        o_item.forEach(e => this.priceInfo.push({id:e.id, minV: e.minPrc}))
      
        res.data.forEach(e => {
          if(this.itemList.indexOf(e.categoryName.trim()) === -1)
          this.itemList.push(e.categoryName.trim())})
      })
    },
    onChange(value){
      this.refreshDashboard()
    },
    moveCategory(){
      this.$router.push('/category')
    },
    moveSite(){
      this.$router.push('/site')
    }
  },
  created(){
    this.refreshDashboard();
  }
};
</script>

<style>
@import 
url(https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css);

</style>
