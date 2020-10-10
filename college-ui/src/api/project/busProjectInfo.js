import request from '@/utils/request'

// 查询项目信息列表
export function listDeclare(query) {
  return request({
    url: '/project/declare/list',
    method: 'get',
    params: query
  })
}

// 查询项目信息列表
export function listPrepare(query) {
  return request({
    url: '/project/prepare/list',
    method: 'get',
    params: query
  })
}

// 查询项目信息列表
export function listSimulate(query) {
  return request({
    url: '/project/simulate/list',
    method: 'get',
    params: query
  })
}

// 查询项目信息列表
export function listEstablish(query) {
  return request({
    url: '/project/establish/list',
    method: 'get',
    params: query
  })
}

// 查询项目信息列表
export function listUrgent(query) {
  return request({
    url: '/project/urgent/list',
    method: 'get',
    params: query
  })
}

// 查询项目信息详细
export function getBusProjectInfo(id) {
  return request({
    url: '/project/busProjectInfo/' + id,
    method: 'get'
  })
}

// 新增项目信息
export function addBusProjectInfo(data) {
  return request({
    url: '/project/busProjectInfo',
    method: 'post',
    data: data
  })
}

// 修改项目信息
export function updateBusProjectInfo(data) {
  return request({
    url: '/project/busProjectInfo',
    method: 'put',
    data: data
  })
}

// 删除项目信息
export function delBusProjectInfo(id) {
  return request({
    url: '/project/busProjectInfo/' + id,
    method: 'delete'
  })
}

// 导出项目信息
export function exportBusProjectInfo(query) {
  return request({
    url: '/project/busProjectInfo/export',
    method: 'get',
    params: query
  })
}

// 项目提交
export function updatePorjectStatus(id,status) {
  return request({
    url: '/project/busProjectInfo/updatePorjectStatus/'+id+'/'+status,
    method: 'get',
    params: id,status
  })
}

// 查询项目详情
export function projectDetails(id) {
  return request({
    url: '/project/busProjectInfo/projectDetails/'+id,
    method: 'get',
    params: id
  })
}

