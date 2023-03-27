<template>
  <div class="box right">
    <dv-border-box-11 class="border-box right-top">
      <dv-charts :option="config8"></dv-charts>
    </dv-border-box-11>
    <dv-border-box-3 class="border-box right-bottom">
      <dv-active-ring-chart :config="config10"
                            style="width:300px;height:300px;margin: auto;" />
    </dv-border-box-3>

  </div>

</template>
<script>
import { config8, config10 } from './config.js'
export default {
  name: 'right',
  data: function () {
    return {
      config8,
      config10,
    }
  },
}
</script>

<style scoped>
.box {
  display: flex;
  flex-direction: column;
}
.right-top {
  margin-bottom: 5%;
  display: flex;
}
.right-bottom {
  margin-top: 5%;
  bottom: 1%;
}
.right {
  height: 90%;
  width: 25%;
}
.dv-border-box-3 {
  height: 150% !important;
}
</style>