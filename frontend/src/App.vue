<template>
  <div id="app">
    <h1>搜索推荐系统</h1>
    <input v-model="query" @input="onSearch" placeholder="请输入关键词" />
    <ul>
      <li v-for="item in results" :key="item">{{ item }}</li>
    </ul>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  data() {
    return {
      query: '',
      results: []
    };
  },
  methods: {
    onSearch() {
      if (this.query.trim() === '') {
        this.results = [];
        return;
      }
      axios.get('http://localhost:8080/api/search', {
        params: { query: this.query }
      }).then(res => {
        this.results = res.data;
      });
    }
  }
};
</script>

<style>
#app {
  max-width: 400px;
  margin: 50px auto;
  font-family: Arial, sans-serif;
}
input {
  width: 100%;
  padding: 8px;
  margin-bottom: 16px;
  box-sizing: border-box;
}
ul {
  list-style: none;
  padding: 0;
}
li {
  background: #f5f5f5;
  margin-bottom: 8px;
  padding: 8px;
  border-radius: 4px;
}
</style>
