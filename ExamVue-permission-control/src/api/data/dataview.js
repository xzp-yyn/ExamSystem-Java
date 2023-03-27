import request from '@/utils/request'
//获取系统的数据
export function getviewdata () {
  return request({
    url: "/data/commonview",
    method: "get"
  })

}
// 获取分数排行榜
export function scoreranking () {
  return request({
    url: "/data/scoreranking",
    method: "get"
  })
}

// question_percentage
// 获取错题百分比
export function getPercentage () {
  return request({
    url: "/data/question_percentage",
    method: "get"
  })
}
