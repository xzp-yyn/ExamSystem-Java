<template>
  <dv-full-screen-container class=" container">
    <dv-loading v-if="loading"
                style="height: 100%;width: 100%;color: white;">Loading....</dv-loading>
    <div class="box left"
         v-if="loading?false:true">
      <dv-border-box-1 class="border-box">
        <dv-capsule-chart :config="config7"
                          class="charts"
                          style="height:300px" />
      </dv-border-box-1>
      <dv-border-box-8 class="border-box">
        <dv-scroll-board :config="config2"
                         class="charts"
                         style="height:380px" />
      </dv-border-box-8>
      <dv-border-box-1 class="border-box">
        <dv-scroll-ranking-board :config="config3"
                                 class="charts"
                                 style="height:300px" />
      </dv-border-box-1>
    </div>

    <div class="box center"
         v-if="loading?false:true">
      <dv-border-box-1 class="border-box">
        <dv-flyline-chart-enhanced :config="config5"
                                   :dev="true"
                                   class="charts"
                                   style="height:800px" />
      </dv-border-box-1>
    </div>

    <div class="box right"
         v-if="loading?false:true">
      <dv-border-box-1 class="border-box">
        <dv-scroll-ranking-board :config="config3"
                                 class="charts"
                                 style="height:300px" />
      </dv-border-box-1>
      <dv-border-box-8 :reverse="true"
                       class="border-box">
        <dv-conical-column-chart :config="config6"
                                 class="charts"
                                 style="height:350px;" />
      </dv-border-box-8>
      <dv-border-box-1 class="border-box">
        <dv-capsule-chart :config="config7"
                          class="charts"
                          style="height:300px" />
      </dv-border-box-1>
    </div>
  </dv-full-screen-container>
</template>
<script>
import {
  config1,
  config2,
  config3,
  config4,
  config5,
  config6,
  config7,
} from './config.js'
export default {
  name: 'test1',
  data: function () {
    return {
      config1,
      config2,
      config3,
      config4,
      config5,
      config6,
      config7,
      loading: true,
    }
  },
}
</script>
<style scoped>
#dv-full-screen-container {
  position: unset;
}
.container {
  display: flex;
  flex-direction: row;
  background-color: #01132c;
}
.left,
.right {
  width: 25%;
}
.center {
  width: 50%;
}
.box {
  display: flex;
  flex-direction: column;
}
.charts {
  width: 90%;
  margin: 5%;
}
</style>