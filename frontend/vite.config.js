import { defineConfig } from 'vite'
import react from '@vitejs/plugin-react'

// https://vite.dev/config/
export default defineConfig({
  plugins: [react()],
  server: {
    host: true,
    port: 5173,
    proxy: {
      '/api': {
//        target: 'http://localhost:8080', // Use localhost (FOR LOCAL DEV)
        target: 'http://backend-app:8080',
         changeOrigin: true,
          // This logging is the key to debugging the proxy
          // Add this bypass function
          bypass: (req, res, proxyOptions) => {
            // Return null to prevent Vite from bypassing the proxy
            return null;
          },
          configure: (proxy, _options) => {
            proxy.on('error', (err, _req, _res) => {
              console.log('proxy error', err);
            });
            proxy.on('proxyReq', (proxyReq, req, _res) => {
              console.log('Sending Request to the Target:', req.method, req.url);
            });
              proxy.on('proxyRes', (proxyRes, req, _res) => {
                console.log('Received Response from the Target:', proxyRes.statusCode, req.url);
              });
          },
      }
    }
  },
})
