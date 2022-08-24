/* eslint-disbable */
<template>
  <div>
    <h3>Category</h3>
    <div class="container">
      <form @submit="validateAndSubmit">
        <div v-if="errors.length">
          <div
            class="alert alert-danger"
            v-bind:key="index"
            v-for="(error, index) in errors"
          >
            {{ error }}
          </div>
        </div>
        <fieldset class="form-group">
          <label>품목명</label>
          <input type="text" class="form-control"
           v-model="prod_name" />
        </fieldset>
        <fieldset class="form-group">
          <label>수집 사이트 선택</label>
          <div v-for="(value, index) in options" :key="index">
            <input type="checkbox" :id="value.id" v-model="selected_site" :value="value.id">{{value.site_name}}</input>
          </div>
           
        </fieldset>
        <button class="btn btn-success" 
        type="submit">Save</button>
      </form>
    </div>
  </div>
</template>
<script>
import CategoryDataService from '../service/CategoryDataService';
import SiteDataService from '../service/SiteDataService';

export default {
  name: "Category",
  data() {
    return {
      prod_name: "",
      selected_site: [],
      options: [],//[{id:1, site_name:'11st'}, {id:2, site_name:'SSG'}],
      errors: [],
    };
  },
  computed: {
    id() {
      return this.$route.params.id;
    },
  },
  mounted(){
    SiteDataService.retrieveAllSites().then((res)=>{
      res.data.forEach(e => {
        this.options.push({id:e.id, site_name:e.siteName})
      })
    })
  },
  methods: {
    refreshCategoryDetails() {
      CategoryDataService.retrieveCategory(this.id).then((res) => {
        this.prod_name = res.data.categoryName;
        this.seleted_site = res.data.targetInfo;
        let temp = res.data.targetInfo.split(",")
        temp.forEach(e => this.selected_site.push(e.toString()))
      });
    },
    validateAndSubmit(e) {
      e.preventDefault();
      this.errors = [];
  
      if (this.errors.length === 0) {
        if (this.id == -1) {
          CategoryDataService.createCategory({
            categoryName: this.prod_name,
            targetInfo: JSON.parse(JSON.stringify(this.selected_site)).join(","),
          }).then(() => {
            this.$router.push("/category");
          });
        } else {
          CategoryDataService.updateCategory(this.id, {
            id: this.id,
            categoryName: this.prod_name,
            targetInfo: JSON.parse(JSON.stringify(this.selected_site)).join(","),
          }).then(() => {
            this.$router.push("/category");
          });
        }
      }
    },
  },
  created() {
    this.refreshCategoryDetails();
  },
};
</script>
