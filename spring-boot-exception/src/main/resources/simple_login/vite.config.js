import { fileURLToPath, URL } from 'node:url'

import { defineConfig } from 'vite'
import vue from '@vitejs/plugin-vue'

// https://vitejs.dev/config/
export default defineConfig({
  plugins: [
    vue(),
  ],
  resolve: {
    alias: {
      '@': fileURLToPath(new URL('./src', import.meta.url))
    }
  },
  base: './', //服务器中放置打包代码的目录名,

  server: {
    port: 8848,
    proxy: {
      // 接口地址代理
      '/api': {
        target: 'http://127.0.0.1:8080/', // 接口的域名
        secure: false, // 如果是https接口，需要配置这个参数
        changeOrigin: true, // 如果接口跨域，需要进行这个参数配置
        rewrite: (path) => path.replace(/^\/api/, '/')
      }
    }
  },
})
