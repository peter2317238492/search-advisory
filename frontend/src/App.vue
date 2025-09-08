<template>
  <div id="app">
    <div class="header">
      <h1>搜索推荐系统</h1>
    </div>
    <div class="search-bar">
      <input v-model="query" @input="onSearch" placeholder="请输入关键词" />
    </div>
    <div class="preview-section">
      <h2>所有物品预览</h2>
      <div class="preview-list">
        <div v-for="item in allItems" :key="item.name" class="preview-item">
          <img :src="item.img" alt="物品图片" class="item-img" />
          <div class="item-info">
            <div class="item-name">{{ item.name }}</div>
            <div class="item-desc">{{ item.desc }}</div>
          </div>
        </div>
      </div>
    </div>
    <div class="results-section">
      <h2>搜索结果</h2>
      <ul>
        <li v-for="item in results" :key="item">{{ item }}</li>
      </ul>
    </div>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  data() {
    return {
      query: '',
      results: [],
  allItems: []
    };
  },
  created() {
    // 获取所有物品列表
    axios.get('http://localhost:8080/api/items').then(res => {
      this.allItems = res.data;
    });
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
  max-width: 700px;
  margin: 40px auto;
  font-family: 'Segoe UI', Arial, sans-serif;
  background: #fff;
  border-radius: 16px;
  box-shadow: 0 6px 32px rgba(0,0,0,0.10);
  padding: 40px 32px;
}
.header {
  text-align: center;
  margin-bottom: 28px;
}
.search-bar {
  margin-bottom: 36px;
}
input {
  width: 100%;
  padding: 14px;
  margin-bottom: 0;
  box-sizing: border-box;
  border: 1.5px solid #e0e0e0;
  border-radius: 8px;
  font-size: 17px;
  transition: border-color 0.2s;
}
input:focus {
  border-color: #409eff;
  outline: none;
}
.preview-section {
  margin-bottom: 36px;
}
.preview-list {
  display: flex;
  flex-wrap: wrap;
  gap: 18px;
}
.preview-item {
  background: #f8fbff;
  border: 1.5px solid #d0eaff;
  border-radius: 10px;
  padding: 16px 18px;
  font-size: 16px;
  color: #409eff;
  box-shadow: 0 2px 12px rgba(64,158,255,0.07);
  display: flex;
  align-items: center;
  min-width: 220px;
  max-width: 320px;
}
.item-img {
  width: 60px;
  height: 60px;
  object-fit: cover;
  border-radius: 8px;
  margin-right: 16px;
  border: 1px solid #e0e0e0;
  background: #fff;
}
.item-info {
  flex: 1;
}
.item-name {
  font-weight: bold;
  font-size: 18px;
  color: #222;
  margin-bottom: 6px;
}
.item-desc {
  font-size: 15px;
  color: #666;
}
.results-section {
  margin-top: 28px;
}
ul {
  list-style: none;
  padding: 0;
}
li {
  background: #f5f5f5;
  margin-bottom: 10px;
  padding: 12px 18px;
  border-radius: 8px;
  font-size: 17px;
  color: #333;
  box-shadow: 0 1px 6px rgba(0,0,0,0.05);
}
</style>
