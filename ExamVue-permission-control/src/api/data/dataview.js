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
// 获取学生已答题数量
export function stuqueRanking () {
  return request({
    url: "/data/stuqueRanking",
    method: "get"
  })
}

//
// 考试及格率
export function passingPercentage () {
  return request({
    url: "/data/passingPercentage",
    method: "get"
  })
}

// perstuPercentage
// 每个学生的及格率
export function perstuPercentage () {
  return request({
    url: "/data/perstuPercentage",
    method: "get"
  })
}
