<template>
  <div class="container">
    <h3> 품목 관리 화면 </h3>
    <div v-if="message" class="alert alert-success">
      {{ this.message }}</div>
        <div class="row">
        <button class="btn btn-success" 
        v-on:click="addCtg()">Add</button>
      </div>
    <div class="container">
      <table class="table">
        <thead>
          <tr> 
            <th> idx </th>
            <th> 품목명 </th>
            <th> 관리 사이트 항목 </th>
            <!-- <th> 판매 가격 </th>
            <th> 경쟁사 가격 </th> -->
            <th> 수정 </th>
            <th> 삭제 </th> 
          </tr>
        </thead>
        <tbody>
          <tr v-for="item in categories" v-bind:key="item.id">
          
            <td>{{ item.id }}</td>
            <td>{{ item.categoryName }}</td>
            <td>{{ item.targetInfo }}</td>
            <!-- <td>{{ item.cur_price }}</td>
            <td>{{ item.other_price }}</td>  -->
            <td>
              <button class="btn btn-warning" 
              v-on:click="updateCtg(item.id)">
                Update
              </button>
            </td>
            <td>
              <button class="btn btn-danger" 
              v-on:click="deleteCtg(item.id)">
                Delete
              </button>
            </td>
          </tr>
        </tbody>
      </table>
    
    </div>
  </div>
</template>
<script>

import CategoryDataService from '../service/CategoryDataService';
import PriceService from '../service/PriceService';

export default {
  name: "Categories",
  data() {
    return {
      categories: [],
      message: "",
      priceInfo:[]
    };
  },
  mounted(){
  },
  methods: {
    refreshCategories() {
      CategoryDataService.retrieveAllCategories().then((res) => {
        this.categories = res.data;
      });
      // PriceService.retrieveAllPrices().then((res) => {
      //   console.log(res)
      //   console.log("categories", this.categories)
      //   res.data.forEach(e => {
      //     console.log(e.categoryName)
      //     console.log("필터",this.categories.filter(x => x.categoryName == e.categoryName))

      //   })
      // })

    },
    addCtg() {
      this.$router.push(`/category/-1`);
    },
    updateCtg(id) {
      this.$router.push(`/category/${id}`);
    },
    deleteCtg(id) {
      CategoryDataService.deleteCategory(id).then(() => {
        this.refreshCategories();
      });
    },
  },
  created() {
    this.refreshCategories();
  },
};
</script>