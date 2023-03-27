<template>
  <div class="box left">
    <dv-border-box-4 class="border-box">
      <dv-scroll-ranking-board :config="config3"
                               class="charts"
                               style="" />
    </dv-border-box-4>
  </div>
</template>
<script>
import { scoreranking } from '@/api/data/dataview'
export default {
  name: 'Boxleft',
  data: function () {
    return {
      data: [],
      config3: {
        data: [],
        unit: '',
      },
    }
  },
  mounted() {
    this.initdata()
  },
  methods: {
    initdata() {
      scoreranking().then((res) => {
        this.config3 = {
          data: res.data,
          unit: '(总分)',
        }
        // console.log(this.config3)
      })
    },
  },
}
</script>
<style scoped>
.box {
  display: flex;
  flex-direction: column;
}
.left {
  width: 25%;
  height: 91% !important;
}
.charts {
  width: 90%;
  margin: 5%;
}
</style>