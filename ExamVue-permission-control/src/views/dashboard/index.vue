<template>
  <div class="dashboard-container">

    <vue-particles color="#6495ED"
                   class="loginbg"
                   :particleOpacity="1.0"
                   :particlesNumber="80"
                   shapeType="star"
                   :particleSize="4"
                   linesColor="#6495ED"
                   :linesWidth="1"
                   :lineLinked="true"
                   :lineOpacity="0.6"
                   :linesDistance="150"
                   :moveSpeed="3"
                   :hoverEffect="true"
                   hoverMode="grab"
                   :clickEffect="true"
                   clickMode="push">
    </vue-particles>
    <el-row style="line-height: 30px">
      <el-row :span="24"
              style="text-align: center;color:#32c5e9;">欢迎使用在线考试数据分析与可视化系统</el-row>
      <el-row :span="24"
              style="text-align: center;align-items: center;">
        <img src="https://img.shields.io/badge/Author-%E8%96%9B%E5%B1%95%E9%B9%8F-brightgreen"
             alt="author" />&nbsp;&nbsp;&nbsp;&nbsp;
        <img src="https://img.shields.io/badge/license-Apache--2.0-brightgreen"
             alt="license" />&nbsp;&nbsp;&nbsp;&nbsp;
        <img src="https://img.shields.io/badge/release-v3.0.0-success"
             alt="release" />&nbsp;&nbsp;&nbsp;&nbsp;
        <img src="https://img.shields.io/badge/Vue-%5E2.9.6-orange"
             alt="Vue" />&nbsp;&nbsp;&nbsp;&nbsp;
        <img src="https://img.shields.io/badge/DataV-%5E2.10.0-orange"
             alt="Datav" />&nbsp;&nbsp;&nbsp;&nbsp;
        <img src="https://img.shields.io/badge/vue--particles-%5E1.0.9-orange"
             alt="Datav" />&nbsp;&nbsp;&nbsp;&nbsp;
      </el-row>
    </el-row>
    <div class="content">
      <el-row>
        本系统基于JDK11采用SpringBoot开发,Maven构建，Git管理代码，Redis缓存，Mysql5.7存储数据，前端则使用Vue框架，结合Element-UI组件,
        DataV+Echarts+Vue-particles的可视化，目前更新至3.0版本；此系统是集登录注册功能，验证码功能，缓存功能，用户验证功能，题库管理，试卷管理，
        用户管理，考试管理，可视化功能于一身，诣在提高学生考试效率，解决老师的管理难，查询难；通过此系统能够对考试数据进行分析后通过可视化大屏展示给学生和老师！
      </el-row>
    </div>
    <div class="map">
      <dv-border-box-1 class="border-box">
        <dv-flyline-chart-enhanced :config="config5"
                                   :dev="true"
                                   class="charts"
                                   style="" />
      </dv-border-box-1>
    </div>
  </div>
</template>

<script>
import { config5 } from './config'
import { mapGetters } from 'vuex'

export default {
  name: 'Dashboard',
  computed: {
    ...mapGetters(['name', 'roles']),
  },
  data: function () {
    return {
      config5,
    }
  },
}
</script>

<style scoped>
.map {
  margin: auto;
  width: 90%;
  height: 70%;
  display: flex;
  flex-direction: column;
}
.charts {
  width: 90%;
  height: 400px;
  margin: 3%;
}
.dashboard-container {
  /* color: white; */
  height: 100%;
  width: 100%;
  margin: 20px;
  font-size: 24px;
  position: absolute;
  background-color: #01132c;
}
.content {
  width: 99%;
  color: #67c23a;
  font-size: 25px;
  font-family: 'smiley';
}
.loginbg {
  width: 100%;
  height: 100%;
  position: fixed;
}
</style>
