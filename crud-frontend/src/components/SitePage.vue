<template>
  <div class="container">
    <h3> 품목 관리 화면 </h3>
    <div v-if="message" class="alert alert-success">
      {{ this.message }}</div>
        <div class="row">
        <button class="btn btn-success" v-on:click="addSite()">Add</button>
      </div>
    <div class="container">
      <table class="table">
        <thead>
          <tr> 
            <th>idx</th>
            <th>사이트명</th>
            <th>사이트 URL</th>
            <th>수정</th>
            <th>삭제</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="item in sites" v-bind:key="item.id">
          
            <td>{{ item.id }}</td>
            <td>{{ item.siteName }}</td>
            <td>{{ item.url }}</td>
            <td>
              <button class="btn btn-warning" 
              v-on:click="updateSite(item.id)">
                Update
              </button>
            </td>
            <td>
              <button class="btn btn-danger" 
              v-on:click="deleteSite(item.id)">
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

import SiteDataService from '../service/SiteDataService';

export default {
  name: "SitePage",
  data() {
    return {
      sites: [],
      message: "",
    };
  },
  methods: {
    refreshSitePage() {
      SiteDataService.retrieveAllSites().then((res) => {
        console.log(res)
        this.sites = res.data;
      });
    },
    addSite() {
      this.$router.push(`/site/-1`);
    },
    updateSite(id) {
      this.$router.push(`/site/${id}`);
    },
    deleteSite(id) {
      SiteDataService.deleteSite(id).then(() => {
        this.refreshSitePage();
      });
    },
  },
  created() {
    this.refreshSitePage();
  },
};
</script>