/* eslint-disbable */
<template>
  <div>
    <h3>Site 관리</h3>
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
          <label>사이트 이름(필수)</label>
          <input type="text" class="form-control"
           v-model="siteName" />
        </fieldset>
        <fieldset class="form-group">
          <label>데이터 수집 사이트 URL 정보(필수)</label>
          <input type="text" class="form-control" 
          v-model="url" />
        </fieldset>
        <fieldset class="form-group">
          <label>button_elem</label>
          <input type="text" class="form-control" 
          v-model="buttonElem" />
        </fieldset>
        <fieldset class="form-group">
          <label>button_class</label>
          <input type="text" class="form-control" 
          v-model="buttonClass" />
        </fieldset>
        <fieldset class="form-group">
          <label>div_container_class</label>
          <input type="text" class="form-control" 
          v-model="divContainerClass" />
        </fieldset>
        <fieldset class="form-group">
          <label>split_elem</label>
          <input type="text" class="form-control" 
          v-model="splitElem" />
        </fieldset>
        <fieldset class="form-group">
          <label>split_elem_class</label>
          <input type="text" class="form-control" 
          v-model="splitElemClass" />
        </fieldset>
        <fieldset class="form-group">
          <label>div_imageclass</label>
          <input type="text" class="form-control" 
          v-model="divImageclass" />
        </fieldset>
        <fieldset class="form-group">
          <label>a-title-Class</label>
            <input type="text" class="form-control" v-model="aTitleclass" placeholder="a Tag 사용시 'clickable'을 입력해주세요"/>
        </fieldset>
        <fieldset class="form-group">
          <label>title element</label>
          <input type="text" class="form-control" 
          v-model="titleElem" />
        </fieldset>
        <fieldset class="form-group">
          <label>title class</label>
          <input type="text" class="form-control" 
          v-model="titleClass" />
        </fieldset>
        <fieldset class="form-group">
          <label>price element</label>
          <input type="text" class="form-control" 
          v-model="priceElem" />
        </fieldset>
        <fieldset class="form-group">
          <label>price class</label>
          <input type="text" class="form-control" 
          v-model="priceClass" />
        </fieldset>

        <button class="btn btn-success" 
        type="submit">Save</button>
      </form>
    </div>
  </div>
</template>
<script>
import SiteDataService from '../service/SiteDataService';
export default {
  name: "Site",
  data() {
    return {
     siteName:"",
     buttonElem:"",
     buttonClass:"",
     divContainerClass:"",
     splitElem:"",
     splitElemClass:"",
     divImageclass:"",
     aTitleclass:"",
     titleElem:"",
     titleClass:"",
     priceElem:"",
     priceClass:"",
     url:"",
      errors: [],
    };
  },
  computed: {
    id() {
      return this.$route.params.id;
    },
  },
  methods: {
    refreshSiteDetails() {
        if(this.id != -1){
            SiteDataService.retrieveSite(this.id).then((res) => {
                console.log(res)
                this.siteName = res.data.siteName
                this.buttonElem = res.data.buttonElem
                this.buttonClass = res.data.buttonClass
                this.divContainerClass = res.data.divContainerClass
                this.splitElem = res.data.splitElem
                this.splitElemClass = res.data.splitElemClass
                this.divImageclass = res.data.divImageclass
                this.aTitleclass = res.data.atitleclass
                this.titleElem = res.data.titleElem
                this.titleClass = res.data.titleClass
                this.priceElem = res.data.priceElem
                this.priceClass = res.data.priceClass
                this.url = res.data.url
            });
      }
    },
    validateAndSubmit(e){
        if(this.errors.length === 0){
            if(this.id == -1){
                SiteDataService.createSite({
                    siteName : this.siteName,
                    buttonElem : this.buttonElem,
                    buttonClass :this.buttonClass,
                    divContainerClass: this.divContainerClass,
                    splitElem: this.splitElem,
                    splitElemClass : this.splitElemClass,
                    divImageclass : this.divImageclass,
                    aTitleclass : this.aTitleclass,
                    titleElem : this.titleElem,
                    titleClass : this.titleClass,
                    priceElem : this.priceElem,
                    priceClass : this.priceClass,
                    url : this.url
                }).then(() => {
                    this.$router.push("/site")
                })
            }else{
                SiteDataService.updateSite(this.id,{
                    id: this.id,
                    siteName : this.siteName,
                    buttonElem : this.buttonElem,
                    buttonClass :this.buttonClass,
                    divContainerClass: this.divContainerClass,
                    splitElem: this.splitElem,
                    splitElemClass : this.splitElemClass,
                    divImageclass : this.divImageclass,
                    aTitleclass : this.aTitleclass,
                    titleElem : this.titleElem,
                    titleClass : this.titleClass,
                    priceElem : this.priceElem,
                    priceClass : this.priceClass,
                    url : this.url
                }).then(() => {
                    this.$router.push("/site")
                })
            }
        }
    }
  },
  created() {
    this.refreshSiteDetails();
  },
};
</script>
