from http.server import SimpleHTTPRequestHandler, HTTPServer

class TVServer(SimpleHTTPRequestHandler):
    def do_POST(self):
        if self.path == '/save-channels':
            content_length = int(self.headers['Content-Length'])
            post_data = self.rfile.read(content_length)
            
            # Overwrite the JSON file
            with open('tamil_tv_sources.json', 'wb') as f:
                f.write(post_data)
                
            self.send_response(200)
            self.send_header('Content-type', 'application/json')
            self.end_headers()
            self.wfile.write(b'{"success": true}')
            print("JSON successfully updated by a device!")
        else:
            self.send_error(404)

print("Tamil Live TV Server running!")
print("Open your browser to: http://localhost:8000/LiveTV.html")
HTTPServer(('0.0.0.0', 8000), TVServer).serve_forever()