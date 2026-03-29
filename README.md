# KOVA VPN

Private VPN client for Android based on VLESS + Reality (Xray core).

## Build

### Requirements (GitHub Secrets)
| Secret | Description |
|--------|-------------|
| `APP_KEYSTORE_BASE64` | base64-encoded `.jks` keystore |
| `APP_KEYSTORE_PASSWORD` | Keystore password |
| `APP_KEYSTORE_ALIAS` | Key alias |
| `APP_KEY_PASSWORD` | Key password |

### Run build
1. Push to `master` → auto-triggers build
2. Or: **Actions → Build KOVA VPN APK → Run workflow** → set `release_tag` to publish a release

### Generate keystore (run once locally)
```bash
keytool -genkey -v \
  -keystore kova.jks \
  -alias kova \
  -keyalg RSA \
  -keysize 2048 \
  -validity 10000

# Encode for GitHub secret:
base64 -i kova.jks | pbcopy
```

## Protocol
VLESS + Reality — hides VPN traffic as regular HTTPS. Works in Russia.

## Panel
3x-ui on VDS. Subscription URL generated per-user.
