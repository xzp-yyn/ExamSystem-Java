<template>
  <div class="center-cmp">
    <div class="cc-header">
      <dv-decoration-1 style="width:200px;height:50px;" />
      <div>xx</div>
      <dv-decoration-1 style="width:200px;height:50px;" />
    </div>

    <div class="cc-details">
      <div>设备总数</div>
      <div class="card">2</div>
      <div class="card">1</div>
      <div class="card">3</div>
      <div class="card">7</div>
    </div>
    <dv-border-box-1 style="height: 52% !important;">
      <!-- <dv-active-ring-chart :config="config"
                            style="" /> -->
    </dv-border-box-1>

  </div>
</template>
<script>
export default {
  name: 'right',
  data: function () {
    return {
      config: {},
    }
  },
  mounted() {
    this.createData()
  },
  methods: {
    createData() {
      this.config = {
        data: [
          {
            name: '收费站',
            value: 1315,
          },
          {
            name: '监控中心',
            value: 415,
          },
          {
            name: '道路外场',
            value: 90,
          },
          {
            name: '其他',
            value: 317,
          },
        ],
        color: ['#00baff', '#3de7c9', '#fff', '#ffc530', '#469f4b'],
        lineWidth: 30,
        radius: '55%',
        activeRadius: '60%',
      }
    },
  },
}
</script>

<style scoped>
.center-cmp {
  width: 31%;
  height: 100%;
  margin: 0px;
  padding: 0px;
  display: flex;
  flex-direction: column;
}
.cc-header {
  height: 70px;
  display: flex;
  justify-content: space-between;
  align-items: center;
  font-size: 30px;
}
.cc-details {
  height: 120px;
  display: flex;
  justify-content: center;
  font-size: 32px;
  align-items: center;
}
.card {
  background-color: rgba(4, 49, 128, 0.6);
  color: #08e5ff;
  height: 70px;
  width: 70px;
  font-size: 45px;
  font-weight: bold;
  line-height: 70px;
  text-align: center;
  margin: 10px;
}
.ccmc-middle {
  width: 50%;
  height: 90%;
}
.active-ring-name {
  font-size: 20px !important;
}
</style>