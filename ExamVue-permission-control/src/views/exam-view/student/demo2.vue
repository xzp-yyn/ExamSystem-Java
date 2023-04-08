<template>
  <div id="data-view">
    <dv-full-screen-container class="container">
      <vue-particles color="#6495ED"
                     style="width: 100%;height: 100%;position: fixed;"
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
      <topHead></topHead>
      <countdata></countdata>
      <dv-loading v-if="loading"
                  style="">Loading....</dv-loading>

      <div class="main-content"
           v-if="loading ? false:true">

        <boxleft></boxleft>
        <mapcenter></mapcenter>
        <boxright></boxright>
      </div>

    </dv-full-screen-container>
  </div>

</template>
<script>
import topHead from './topHead2'
import countdata from './countdata2'
import mapcenter from './center2'
import boxleft from './boxleft2'
import boxright from './boxright2'

export default {
  components: { topHead, countdata, mapcenter, boxleft, boxright },
  name: 'demo1',
  data() {
    return {
      loading: false,
    }
  },
  methods: {},
}
</script>

<style lang="less">
/*1.显示滚动条：当内容超出容器的时候，可以拖动：*/
::v-deep .el-drawer__body {
  overflow: auto;
}
#dv-full-screen-container {
  position: unset;
  width: 100% !important;
  height: 102% !important;
}
#data-view {
  position: absolute;
  color: white;
  width: 99%;
  height: 100%;
  margin-top: 1%;
  .container {
    display: flex;
    flex-direction: column;
    // background-image: url(../assets/bg2.png);
    // background-repeat: no-repeat;
    // background-size: 100% 100%;
    background-color: #01132c;
  }
  .main-content {
    flex: 1;
    margin-top: 1%;
    display: flex;
    flex-direction: row;
    height: 85%;
  }
}
</style>

